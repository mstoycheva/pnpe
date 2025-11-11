package exceptions;

public class NoMoreTicketException extends RuntimeException {
    public NoMoreTicketException(String message) {
        super(message);
    }
    @Override
    public String getMessage() {
        return "No more tickets available!";
    }
}
