void main() {
    Laptop laptop = new Laptop();
    laptop.name = "Department Laptop";
    laptop.available = true;
    laptop.memoryGb = 16;
    System.out.println(laptop.getEquipmentId());
    System.out.println(laptop.available);
    laptop.markBorrowed();
    System.out.println(laptop.available);

}