public class Laptop extends Equipment {

    public int memoryGb;

    public Laptop(String equipmentId, String name, int memoryGb) {
        super(equipmentId, name);
        this.memoryGb = memoryGb;
    }

    public void markBorrowed() {
        available = false;
    }

    @Override
    public String description() {
        return super.description()
                + " | Memory: " + memoryGb + " GB";
    }

    @Override
    public String toString() {
        return description();
    }
}