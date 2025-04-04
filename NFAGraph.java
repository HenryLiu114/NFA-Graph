import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class NFAGraph {
    private HashMap<String, Vertex> map;

    public NFAGraph(){
        map = new HashMap<>();
    }

    public Vertex getVertex(String key){
        return map.get(key);
    }

    public HashMap<String, Vertex> getMap(){
        return map;
    }
    public int addVertex(String dataPoint){
        Vertex n = new Vertex(dataPoint);
        map.put(dataPoint, n);
        return 1;
    }

    public int addEdge(String traversalReq, String startingDataPoint, String nextDataPoint){
        Edge n = new Edge(traversalReq, map.get(nextDataPoint));
        if(map.containsKey(nextDataPoint)){
            map.get(startingDataPoint).addPointer(n);
            return 1;
        }
        else{
            return 0;
        }
    }

    public int setFinalState(String dataPoint){
        if(map.containsKey(dataPoint)){
            map.get(dataPoint).setFinal(true);
            return 1;
        }
        else{
            return 0;
        }
    }

    public int removeFinalState(String dataPoint){
        if(map.containsKey(dataPoint) && map.get(dataPoint).isFinal()){
            map.get(dataPoint).setFinal(false);
            return 1;
        }
        else{
            return 0;
        }
    }

    public boolean traverse(String input, String startState){
        Vertex start = map.get(startState);
        LinkedList<Edge> startPointer = new LinkedList<>();
        if(start.getPointers() != null && start.getPointers().size() > 0){
            startPointer = start.getPointers();
        }
        
        boolean isAccepted = start.isFinal();
        Queue<String> inputQueue = new LinkedList<>();
        for(int i = 0; i < input.length(); i++){
            inputQueue.add(""+input.charAt(i));
        }

        String cur = "";
        while(!inputQueue.isEmpty()){
            cur = inputQueue.remove();
            int i =0;
            boolean isFinished = false;
            while(i < startPointer.size() && !isFinished){
                if(cur.equals(startPointer.get(i).getTraversalReq())){
                    start = startPointer.get(i).getNextState();
                    startPointer = start.getPointers();
                    isAccepted = start.isFinal();
                    isFinished = true;
                }
                else{
                    i++;
                    isFinished = false;
                }
            }
        }
        return isAccepted;
    }

    public void displayNFA(){
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()){
            String n = it.next();
            for(int i = 0; i < map.get(n).getPointers().size(); i++){
                System.out.println("{" + n + "} --"+ map.get(n).getPointers().get(i).getTraversalReq() +"--> {" +map.get(n).getPointers().get(i).getNextState().getName()+ "}");
            } 
        }
    }
}
