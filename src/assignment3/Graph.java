import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    List<Task> nodes = new ArrayList<Task>();
    Task first;
    Task last;

    public Graph() {
        Task A = new Task("A",10);
        Task B = new Task("B",20);
        Task C = new Task("C",5);
        Task D = new Task("D",10);
        Task E = new Task("E",20);
        Task F = new Task("F",15);
        Task G = new Task("G",5);
        Task H = new Task("H",15);

        A.addConnection(F);
        A.addConnection(B);
        A.addConnection(H);

        B.addConnection(C);

        C.addConnection(G);
        C.addConnection(D);

        D.addConnection(E);

        F.addConnection(G);

        G.addConnection(E);

        H.addConnection(E);

        nodes.add(A);
        nodes.add(B);
        nodes.add(C);
        nodes.add(D);
        nodes.add(E);
        nodes.add(F);
        nodes.add(G);
        nodes.add(H);
    }


    public void calculateEarliest() {
        System.out.println("------Earliest Start & Finish------------");

        nodes.get(0).calculateEariest(0);


        for (Task t: this.nodes) {
            System.out.println(t.getId() + " :: Earliest Start: " + t.getEarliestStart() + " and Finish " + t.getEarliestFinish());
        }
    }

    public void calculateLatest() {
        System.out.println("------Latest Start & Finish------------");
        Task last = nodes.get(4);
        last.setLatestFinish(last.getEarliestFinish());
        last.calculateLatest(last.getEarliestFinish());

        for (Task t: this.nodes) {
            System.out.println(t.getId() + " :: Latest Start: " + t.getLatestStart() + " and Finish " + t.getLatestFinish());
        }
    }

    public void calculateCritical() {
        System.out.println("------Critical Path------------");
        for (Task t: this.nodes) {
            if(t.getEarliestStart() == t.getLatestStart() && t.getEarliestFinish() == t.getLatestFinish()){
                System.out.print(t.getId() + "->");
            }
        }
        System.out.println();
    }

    public void calculateTF() {
        System.out.println("------Total Float------------");
        for (Task t: this.nodes) {
            if(t.getEarliestStart() != t.getLatestStart() && t.getEarliestFinish() != t.getLatestFinish()) {
                t.setTotalFloat(t.getLatestStart()-t.getEarliestStart());
                System.out.println(t.getId() + " :: Total Float: " + (t.getTotalFloat()));
            }
        }
    }

    public void calculateDrag() {
        System.out.println("------Drag------------");
        for (Task t: this.nodes) {
            if(t.getEarliestStart() == t.getLatestStart() && t.getEarliestFinish() == t.getLatestFinish()){
                int drag = t.getDuration();
                for (Task f: t.getFrom()) {
                    for( Task c : f.getConnections()){
                        if(c.getTotalFloat() < drag && c.getTotalFloat() != 0){
                            drag = c.getTotalFloat();
                        }
                    }

                }
                t.setDrag(drag);

                System.out.println(t.getId() + " :: Drag: " + t.getDrag());
            }
        }
    }

}
