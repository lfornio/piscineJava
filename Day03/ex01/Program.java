public class Program {
    private static final String EGG = "Egg";
    private static final String HEM = "Hem";
    private static final String HUMAN = "Human";
    private static final String KEY = "--count=";

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            printError("Error arguments");
        }

        int number = getNumber(args[0]);

        Print print = new Print();
        Thread producer = new Thread(new Producer(EGG, number, print));
        Thread consumer = new Thread(new Consumer(HEM, number, print));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();


        for (int i = 0; i < number; i++) {
            System.out.println(HUMAN);
        }
    }

    public static int getNumber(String source) {
        if (source.length() == 0 || !source.startsWith(KEY)) {
            printError("Error arguments");
        }

        int result = 0;

        try {
            result = Integer.parseInt(source.substring(source.indexOf("=") + 1));
            if (result <= 0) {
                printError("Error number");
            }
        } catch (NumberFormatException ex) {
            printError("Error number");
        }

        return result;
    }

    public static void printError(String error) {
        System.err.println(error);
        System.exit(-1);
    }
}