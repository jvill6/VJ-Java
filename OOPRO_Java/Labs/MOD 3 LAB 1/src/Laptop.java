public class Laptop extends Equipment {
    public int memoryGb;
    public void markBorrowed() {
        available = false;
    }
}