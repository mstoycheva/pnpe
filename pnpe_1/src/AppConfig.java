public class AppConfig {
    private static String APP_NAME;
    private static String VERSION;
    private static String AUTHOR;

    private static void printInfo() {
        System.out.println(APP_NAME + " " + VERSION + " " + AUTHOR);
    }

    public static void main(String[] args) {
        APP_NAME = "App";
        VERSION = "2.0";
        AUTHOR = "Marieta";
        printInfo();
    }
}
