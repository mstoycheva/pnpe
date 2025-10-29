public class NegativePriceException extends Exception {
    private String message;

    public NegativePriceException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
