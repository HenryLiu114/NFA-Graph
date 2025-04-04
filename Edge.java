public class Edge {
    private String traversalReq;
    private Vertex nextState;

    public Edge(String travel, Vertex nextNode){
        traversalReq = travel;
        nextState = nextNode;
    }

    public String getTraversalReq() {
        return traversalReq;
    }

    public void setTraversalReq(String traversalReq) {
        this.traversalReq = traversalReq;
    }

    public Vertex getNextState() {
        return nextState;
    }

    public void setNextState(Vertex nextState) {
        this.nextState = nextState;
    }

    
}