import java.util.HashMap;
import java.util.LinkedList;

public class VertexSet {
    private LinkedList<Vertex> set;

    public VertexSet(){
        set = new LinkedList<>();
    }

    public void addToSet(Vertex n){
        set.add(n);
    }

    public LinkedList<Vertex> getSet(){
        return set;
    }

    public boolean isEmpty(){
        return set.isEmpty();
    }

    public VertexSet traverse(String v){
        VertexSet res = new VertexSet();
        HashMap<String, Boolean> check = new HashMap<>();
        for(int i = 0; i < set.size(); i++){
            LinkedList<Edge> n = set.get(i).getPointers();
            for(int j = 0; j < n.size(); j++){
                if(n.get(j).getTraversalReq().equals(v+"") && !check.containsKey(n.get(j).getNextState().getName())){
                    check.put(n.get(j).getNextState().getName(), true);
                    res.addToSet(n.get(j).getNextState());
                }
            }
        }
        return res;
    }

    public void checkForEpsilon(){
        for(int i = 0; i < set.size(); i++){
            LinkedList<Edge> n = set.get(i).getPointers();
            for(int j = 0; j < n.size(); j++){
                if(n.get(j).getTraversalReq().equals("$")){
                    set.add(n.get(j).getNextState());
                }
            }
        }
    }

    public String setToString(){
        String res = "";
        for(int i = 0; i < set.size()-1; i++){
            res = res + set.get(i).getName() + ", ";
        }
        if(set.size() > 0){
            res = res + set.getLast().getName();
        }
        
        
        return res;
    }
    public int pointerSize(){
        return set.size();
    }

    private boolean contains(Vertex n){
        int i = 0;
        boolean isTrue = false;
        while(i < set.size() && isTrue){
            if(set.get(i).getName().equals(n.getName())){
                isTrue = true;
            }
            else{
                i++;
            }
        }

        return isTrue;
    }
}
