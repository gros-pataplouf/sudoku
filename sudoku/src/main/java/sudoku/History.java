package sudoku;

public class History {
    private Snapshot current;
    public History() {
        this.current = null;
    }
    public void add(String board) {
        Snapshot newSnapshot = new Snapshot(board);
        if (this.current != null) {
            this.current.addNext(newSnapshot);
            newSnapshot.setPrevious(this.current);
        }
        this.current = newSnapshot;
    }
    public String now() {
        return this.current.getContent();
    }
    public void back() {
        this.current = this.current.getPrevious();
    }
    
}
