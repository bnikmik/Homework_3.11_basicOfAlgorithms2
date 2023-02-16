package exceptions;

public class NonexistentIndexException extends RuntimeException{
    public NonexistentIndexException() {
    }

    public NonexistentIndexException(String message) {
        super(message);
    }
}
