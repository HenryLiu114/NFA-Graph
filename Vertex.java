import java.util.LinkedList;

public class Vertex{
    private String name;
    private LinkedList<Edge> pointers;
    private boolean isFinal;
    
    public Vertex(String dat){
        name = dat;
        pointers = new LinkedList<>();
        isFinal = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LinkedList<Edge> getPointers() {
        return pointers;
    }

    public void setPointers(LinkedList<Edge> pointers) {
        this.pointers = pointers;
    }

    public void addPointer(Edge a){
        pointers.add(a);
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean isFinal) {
        this.isFinal = isFinal;
    }

    public boolean hasEdge(String traversal){
        for(int i = 0; i < pointers.size(); i++){
            String n = pointers.get(i).getTraversalReq();
            if(n.equals(traversal)){
                return true;
            }
        }

        return false;
    }
}