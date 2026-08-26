public class Equipment {
    private final String equipmentId;
    private String name;
    private boolean available;
    private double dailyLateFee;
    private int timesBorrowed;


    public Equipment(
            String equipmentId,
            String name,
            double dailyLateFee
    ) {
        if (equipmentId == null || equipmentId.isBlank()) {
            throw new IllegalArgumentException(
                    "Equipment ID must not be blank.");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Equipment name must not be blank.");
        }
        if (dailyLateFee < 0.0) {
            throw new IllegalArgumentException(
                    "Daily late fee must not be negative.");
        }
        // Validate required text first.
        // Validate the numerical value.
        // Normalize acceptable text using strip().
        // Assign fields only after validation succeeds.
        // Preserve the initial state from Laboratory 2.


        this.equipmentId = equipmentId;
        this.name = name;
        this.dailyLateFee = dailyLateFee;
        this.available = true;
        this.timesBorrowed = 0;
    }



    public String getEquipmentId() {
        return equipmentId;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public boolean isAvailable() {
        return available;
    }


    public void borrow() {
        this.available = false;
        this.timesBorrowed++;
    }


    public void returnEquipment() {
        this.available = true;
    }


    public boolean canBeBorrowed() {
        return this.isAvailable();
        //i legit don't know why this is required to be added, the "isAvailable" method already answers this question
    }


    public void setDailyLateFee(double dailyLateFee) {
        this.dailyLateFee = dailyLateFee;
    }


    public double calculateLateFee(int overdueDays) {
        return overdueDays * dailyLateFee;
    }


    public int getTimesBorrowed() {
        return timesBorrowed;
    }


    public void setTimesBorrowed(int timesBorrowed) {
        this.timesBorrowed = timesBorrowed;
    }
}

