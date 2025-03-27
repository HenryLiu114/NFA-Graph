import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class NFAToDFAConversion {
    public static NFAGraph convertToDFA(NFAGraph graph, String[] avaiableTraversals, String startState){
        NFAGraph dfa = new NFAGraph(); //Return value
        VertexSet currentNode = new VertexSet(); //Traversals
        currentNode.addToSet(graph.getVertex(startState)); //Add the start State to traversal
        currentNode.checkForEpsilon();
        Queue<VertexSet> queue = new LinkedList<>();
        queue.add(currentNode);
        dfa.addVertex(currentNode.setToString());
        HashMap<String, Boolean> checks = new HashMap<>();
        for(int k = 0; k < currentNode.pointerSize(); k++){
            if(currentNode.getSet().get(k).isFinal()){
                dfa.setFinalState(currentNode.setToString());
            }
        }

        while(!queue.isEmpty()){
            VertexSet temp = queue.remove();
            for(String i : avaiableTraversals){
                VertexSet n = temp.traverse(i);
                n.checkForEpsilon();
                if(n.getSet().size() > 0){
                    if(!dfa.getMap().containsKey(n.setToString())){
                        dfa.addVertex(n.setToString());
                        for(int k = 0; k < n.pointerSize(); k++){
                            if(n.getSet().get(k).isFinal()){
                                dfa.setFinalState(n.setToString());
                            }
                        }
                    }
                    
                    if(!checks.containsKey(n.setToString()) && !queue.contains(n)){
                        queue.add(n);
                        
                    }
                    if(!dfa.getVertex(temp.setToString()).hasEdge(i+"")){
                        dfa.addEdge(i+"", temp.setToString(), n.setToString());
                    }                     
                }
                else{
                    if(!dfa.getMap().containsKey("dead")){
                        dfa.addVertex("dead");
                        for(int j = 0; j < avaiableTraversals.length; j++){
                            dfa.addEdge(avaiableTraversals[j]+"", "dead", "dead");
                        }
                        checks.put("dead", true);
                    }
                    dfa.addEdge(i+"", temp.setToString(), "dead");
                } 
            }
            checks.put(temp.setToString(), true);
        }
        return dfa;
    }

    //Debug Method
    private static void displayQueue(Queue<VertexSet> n){
        Queue<VertexSet> b = new LinkedList<>(n);
        while(!b.isEmpty()){
            System.out.print(b.remove().setToString());
            if(!b.isEmpty()){
                System.out.print(", ");
            }
        }

    }
}
