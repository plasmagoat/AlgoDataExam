import java.util.ArrayList;
import java.util.List;

public class Task {

    private String id;
    private List<Task> connections = new ArrayList<Task>();
    private List<Task> from = new ArrayList<Task>();
    private int duration;

    private int earliestStart;
    private int earliestFinish;

    private int latestStart;
    private int latestFinish;

    private int totalFloat;
    private int drag;

    public Task(String ID, int duration) {
        this.id = ID;
        //this.connections = connections;
        this.duration = duration;
    }

    public int getDrag() {
        return drag;
    }

    public void setDrag(int drag) {
        this.drag = drag;
    }

    public void addConnection(Task t) {
        t.addFrom(this);
        this.connections.add(t);
    }

    public void addFrom(Task t) {
        this.from.add(t);
    }

    public List<Task> getConnections() {
        return this.connections;
    }

    public int getDuration() {
        return this.duration;
    }

    public String getId() {
        return this.id;
    }

    public int getEarliestFinish() {
        return this.earliestFinish;
    }

    public int getEarliestStart() {
        return this.earliestStart;
    }

    public int getLatestStart() {
        return latestStart;
    }

    public void setLatestStart(int latestStart) {
        this.latestStart = latestStart;
    }

    public int getLatestFinish() {
        return latestFinish;
    }

    public void setLatestFinish(int latestFinish) {
        this.latestFinish = latestFinish;
    }

    public void setTotalFloat(int totalFloat) {
        this.totalFloat = totalFloat;
    }

    public int getTotalFloat() {
        return this.totalFloat;
    }

    public List<Task> getFrom() {
        return this.from;
    }

    public void calculateEariest(int startTime) {
        if(this.earliestStart < startTime + 1){
            this.earliestStart = startTime + 1;
            this.earliestFinish = startTime + this.duration;
        }
        for (Task c: this.connections) {
            c.calculateEariest(this.earliestFinish);
        }
    }

    public void calculateLatest(int finish) {
        if(this.latestFinish > finish -1 || this.latestFinish == 0){
            this.latestFinish = finish;
            this.latestStart = this.latestFinish - this.duration +1;
        }
        for (Task t: this.from) {
            t.calculateLatest(this.latestStart - 1);
        }
    }
}
