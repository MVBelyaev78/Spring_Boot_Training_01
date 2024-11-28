package exception;

public class IdIsAlreadyPresentException extends RuntimeException{
    public IdIsAlreadyPresentException(String message) {
        super(message);
    }
}
