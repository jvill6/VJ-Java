public class TestAnimals {
    void main(String[] args) {
        Fish d = new Fish();
        Cat c = new Cat("Fluffy");
        Animal a = new Fish();
        Animal e = new Spider();
        Pet p = new Cat("Whiskers");

        d.walk();
        d.eat();
        System.out.println(d.getName());
        d.setName("Fish 1");
        d.play();

        d.walk();
        d.eat();
        System.out.println(d.getName());
        d.setName("Fish 1");
        d.play();

        a.walk();
        a.eat();

        e.eat();

        System.out.println(p.getName());
        p.setName("Cat 2");






    }
}
