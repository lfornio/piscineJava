public class Print {
    private int flag;

    public synchronized void printForProducer(String message) {
        while (flag == 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        flag = 1;
        System.out.println(message);
        notify();
    }

    public synchronized void printForConsumer(String message) {
        while (flag == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
        flag = 0;
        System.out.println(message);
        notify();
    }
}