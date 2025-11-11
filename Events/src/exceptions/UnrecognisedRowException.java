package exceptions;

public class UnrecognisedRowException extends RuntimeException {
    public UnrecognisedRowException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "The row wasn't recognised!";
    }
}
