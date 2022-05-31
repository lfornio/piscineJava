public class Consumer implements Runnable {
    private Print print;
    private String message;
    private int number;

    public Consumer(String message, int number, Print print) {
        this.message = message;
        this.number = number;
        this.print = print;
    }

    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            print.printForConsumer(message);
        }
    }
}
