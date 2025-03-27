import java.util.Scanner;
public class test{
    public static void main(String[] args){
        NFAGraph graph = new NFAGraph();
        boolean done = false;
        Scanner myObj = new Scanner(System.in);

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("nondecimal");
        graph.addVertex("hexadecimal");
        graph.addVertex("hexadecimalB");
        graph.addVertex("hexadecimalC");
        graph.addVertex("octal");
        graph.addVertex("octalB");
        graph.addVertex("octalC");
        graph.addVertex("dead");
        graph.addVertex("float");
        graph.addVertex("floatB");
        graph.addVertex("floatC");
        graph.addVertex("exponent");
        graph.addVertex("exponentB");
        graph.addVertex("exponentC");
        graph.addVertex("exponentD");
        graph.addVertex("exponentFloat");
        graph.addVertex("exponentFloatB");
        graph.addVertex("exponentFloatC");
        graph.addVertex("floatExponent");
        graph.addVertex("floatExponentB");
        graph.addVertex("floatExponentC");
        graph.addVertex("floatExponentD");
        graph.addVertex("floatWithDecimalExponent");
        graph.addVertex("floatWithDecimalExponentB");
        graph.addVertex("floatWithDecimalExponentC");
        graph.setFinalState("B");
        graph.setFinalState("D");
        graph.setFinalState("hexadecimalB");
        graph.setFinalState("octalB");
        graph.setFinalState("floatB");
        graph.setFinalState("exponentB");
        graph.setFinalState("exponentFloatB");
        graph.setFinalState("floatExponentB");
        graph.setFinalState("floatWithDecimalExponentB");

        graph.addEdge("123456789", "A", "B");
        graph.addEdge("123456789", "B", "B");
        graph.addEdge("_", "B", "C");
        graph.addEdge("0123456789", "C", "B");
        graph.addEdge("_", "C", "dead");
        graph.addEdge("0", "B", "D");
        graph.addEdge("$", "D", "B");
        graph.addEdge("0", "D", "D");
        graph.addEdge("0", "D", "D");
        graph.addEdge("_", "D", "E");
        graph.addEdge("0123456789", "E", "D");
        graph.addEdge("0", "A", "nondecimal");

        //hexadecimal values
        graph.addEdge("Xx", "nondecimal", "hexadecimal");
        graph.addEdge("0123456789abcdef", "hexadecimal", "hexadecimalB");
        graph.addEdge("0123456789abcdef", "hexadecimalB", "hexadecimalB");
        graph.addEdge("_", "hexadecimalB", "hexadecimalC");
        graph.addEdge("_", "hexadecimalC", "dead");
        graph.addEdge("0123456789abcdef", "hexadecimalC", "hexadecimalB");

        //octal values
        graph.addEdge("Oo", "nondecimal", "octal");
        graph.addEdge("01234567", "octal", "octalB");
        graph.addEdge("01234567", "octalB", "octalB");
        graph.addEdge("_", "octalB", "octalC");
        graph.addEdge("_", "octalC", "dead");
        graph.addEdge("01234567", "octalC", "octalB");

        //floating point values
        graph.addEdge(".", "nondecimal", "float");
        graph.addEdge(".", "B", "float");
        graph.addEdge(".", "D", "float");
        graph.addEdge("0123456789", "float", "floatB");
        graph.addEdge("0123456789", "floatB", "floatB");
        graph.addEdge("_", "floatB", "floatC");
        graph.addEdge("0123456789", "floatC", "floatB");

        graph.addEdge("eE", "floatC", "floatExponent");
        graph.addEdge("0123456789", "floatExponent", "floatExponentB");
        graph.addEdge("+-", "floatExponent", "floatExponentC");
        graph.addEdge("0123456789", "floatExponentB", "floatExponentB");
        graph.addEdge("_", "floatExponentB", "floatExponentD");
        graph.addEdge("0123456789", "floatExponentD", "floatExponentB");

        graph.addEdge(".", "floatExponentB", "floatWithDecimalExponent");
        graph.addEdge("0123456789", "floatWithDecimalExponent", "floatWithDecimalExponentB");
        graph.addEdge("0123456789", "floatWithDecimalExponentB", "floatWithDecimalExponentB");
        graph.addEdge("eE", "floatWithDecimalExponentB", "dead");
        graph.addEdge("_", "floatWithDecimalExponentB", "floatWithDecimalExponentC");
        graph.addEdge("0123456789", "floatWithDecimalExponentC", "floatWithDecimalExponentB");


        graph.addEdge("0123456789", "floatExponentB", "floatExponentB");
        graph.addEdge("_", "floatExponentB", "floatExponentD");
        graph.addEdge("0123456789", "floatExponentD", "floatExponentB");

        //exponent values
        graph.addEdge("eE", "A", "exponent");
        graph.addEdge("eE", "B", "exponent");
        graph.addEdge("eE", "D", "exponent");
        graph.addEdge("+-", "exponent", "exponentC");
        graph.addEdge("0123456789", "exponent", "exponentB");
        graph.addEdge("0123456789", "exponentC", "exponentB");
        graph.addEdge("0123456789", "exponentB", "exponentB");
        graph.addEdge("0123456789", "exponentD", "exponentB");
        graph.addEdge("_", "exponentB", "exponentD");

        graph.addEdge(".", "exponentB", "exponentFloat");
        graph.addEdge("0123456789", "exponentFloat", "exponentFloatB");
        graph.addEdge("_", "exponentFloatB", "exponentFloatC");
        graph.addEdge("0123456789", "exponentFloatC", "exponentFloatB");
        graph.addEdge("0123456789", "exponentFloatB", "exponentFloatB");
        graph.addEdge("0123456789", "exponentFloatB", "exponentFloatB");
        graph.addEdge("eE", "exponent", "dead");
        graph.addEdge("eE", "exponent", "dead");
        graph.displayNFA();




        while(!done){
            System.out.println("Enter a number: ");
            String input = myObj.nextLine();
            if(input.equals("D")){
                done = true;
            }
            else{

                if(graph.traverse(input,"A")){
                    System.out.println(input+" is valid");
                }
                else{
                    System.out.println(input+" is not valid");
                }
            }
        }

        System.out.println(graph.traverse("4004","A"));
        System.out.println(graph.traverse("4004","A"));


        char[] a = {'0', '1','2','3','4','5','6','7','8','9'};
        //graph.displayNFA();
       // NFAGraph n = NFAToDFAConversion.convertToDFA(graph, a, "A");
        //System.out.println(n.traverse("123","A"));
        //n.displayNFA();

    }
}