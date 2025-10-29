public class YearTaxiException extends Exception {
    private String message;

    public YearTaxiException(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
