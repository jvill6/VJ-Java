//This is legit just here for the requirements, this program isn't complex enough to justify having this here
public class InvalidOrderArgumentException extends IllegalArgumentException {
    public InvalidOrderArgumentException(String message) {
        super(message);
    }
}
