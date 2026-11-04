public class Spider extends Animal {
    Spider() {
        legs = 8;
    }

    void eat() throws InvalidActionException {

        int foodValue = (int) Math.ceil(Math.random()*3);

        if (foodValue < 2) {
            throw new InvalidActionException("The Value of this food was too low for the spider.");
        } else {
            System.out.println("The Spider ate.");
        }
    }

}
