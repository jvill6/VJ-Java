public class Fish extends Animal implements Pet {

    String name;

    Fish() {
        this.legs = 0;
    }

    @Override
    void walk() {
        System.out.println("Fishes cannot walk!");
    }

    void eat() {
        System.out.println("The fish eats.");
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void play() {
        System.out.println("The cat plays");
    }
}
