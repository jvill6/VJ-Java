public class Cat extends Animal implements Pet{
    String name;

    Cat(String name) {
        this.name = name;
        legs = 4;
    }

    Cat() {
        this("");
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

    void eat() {
        System.out.println("The cat ate");
    }




}
