void main() {
    Shape shapes[] = new Shape[2];

    shapes[0] = new Circle(7.27);
    shapes[1] = new Square(7.27);

    for (int i = 0; i < shapes.length; i++) {
        shapes[i].displayInfo();
    }
}