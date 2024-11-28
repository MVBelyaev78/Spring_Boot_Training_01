package exception;

public class NameIsAbsentException extends RuntimeException {
    public NameIsAbsentException(String message) {
        super(message);
    }
}
