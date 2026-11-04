public abstract class Animal {
    protected int legs;

    protected Animal() {
        legs = 0;
    }

    abstract void eat() throws InvalidActionException;

    void walk() {
        System.out.println("The animal walks on " + legs + " legs.");
    }
}
