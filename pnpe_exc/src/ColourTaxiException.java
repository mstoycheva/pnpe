public class ColourTaxiException extends Exception {
    private String message;

    public ColourTaxiException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
