public class Equipment {
    private String equipmentId;
    public String name;
    public boolean available;

    public Equipment(String equipmentId, String name) {
        this.equipmentId = equipmentId;
        this.name = name;
        this.available = true;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public String description() {
        return equipmentId + " | " + name;
    }
}