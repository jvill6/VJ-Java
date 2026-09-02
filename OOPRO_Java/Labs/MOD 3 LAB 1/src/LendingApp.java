void main() {
    Laptop laptop = new Laptop();
    laptop.equipmentId = "EQ-1001";
    laptop.name = "Department Laptop";
    laptop.available = true;
    laptop.memoryGb = 16;
    System.out.println(laptop.equipmentId);
    System.out.println(laptop.name);
    System.out.println(laptop.available);
    System.out.println(laptop.memoryGb);
}