public class Main {
    public static void getPrice(double price) throws NegativePriceException {
        if(price <= 0) {
            throw new NegativePriceException("Negative price");
        }

    }
    public static void checkTaxiConditions(Taxi taxi) throws ColourTaxiException, YearTaxiException {
        if(!taxi.getColour().equals("yellow")) {
            throw new ColourTaxiException("Colour does not match");
        }
        if(taxi.getYear() > 10) {
            throw new YearTaxiException("Too old");
        }
    }

    public static void main(String[] args) throws YearTaxiException {
//        try {
//            getPrice(-10.0);
//        } catch(NegativePriceException e) {
//            System.out.println(e.getMessage());
//        }
        Taxi taxi = new Taxi("red", 20);
        try {
            checkTaxiConditions(taxi);
        } catch (YearTaxiException e) {
            System.out.println(e.getMessage());
        } catch (ColourTaxiException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}