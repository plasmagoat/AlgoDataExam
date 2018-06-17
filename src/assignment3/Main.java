public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.calculateEarliest();
        System.out.println();
        g.calculateLatest();
        System.out.println();
        g.calculateCritical();
        System.out.println();
        g.calculateTF();
        System.out.println();
        g.calculateDrag();

    }
}
