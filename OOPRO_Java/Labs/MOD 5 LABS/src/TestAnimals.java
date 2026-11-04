public class TestAnimals {
    void main(String[] args) throws InvalidActionException {
        Animal[ ] animals = {
                new Cat("Fluffy"),
                new Fish(),
                new Spider()
        };

        animals[2].eat();
    }
}
