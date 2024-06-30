package sudoku;
import java.util.ArrayList;

public class Snapshot {
    private String content;
    private Snapshot previous;
    private ArrayList<Snapshot> next;
    public Snapshot(String content) {
        this.content = content;
        this.previous = null;
        this.next = new ArrayList<>();
    }
    public void setPrevious(Snapshot snapshot) {
        this.previous = snapshot;
    }
    public Snapshot getPrevious() {
        return this.previous;
    }
    public void addNext(Snapshot snaphot) {
        this.next.add(snaphot);
    }
    public String getContent() {
        return this.content;
    }
    
}
