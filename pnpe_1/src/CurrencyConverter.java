import java.util.Scanner;

public class CurrencyConverter {
    private static double USD_EUR;
    private static double EUR_BGN;

    public static double convertUsdToEur() {
       return USD_EUR * 0.86;
    }

    public static double convertEurToBgn() {
        return EUR_BGN * 1.96;
    }

    public static void main(String[] args) {
        System.out.println("Enter USD EUR to convert: ");
        USD_EUR = new Scanner(System.in).nextDouble();
        System.out.println("Enter EUR BGN to convert: ");
        EUR_BGN = new Scanner(System.in).nextDouble();
        System.out.println("Convert USD to EUR: " + convertUsdToEur());
        System.out.println("Convert EUR to BGN: " + convertEurToBgn());
    }
}
