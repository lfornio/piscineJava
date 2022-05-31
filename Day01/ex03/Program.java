import java.util.UUID;

public class Program {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {
        System.out.println(ANSI_GREEN + "PRINT USERS" + ANSI_RESET);
        User Lena = new User("Lena", 5000);
        User Roma = new User("Roma", 2000);
        System.out.println(Lena.toString());
        System.out.println(Roma.toString());

        TransactionsLinkedList list = new TransactionsLinkedList();
        for (int i = 1; i <= 11; i++) {
            if (i % 2 == 0) {
                list.add(Transaction.createTransaction(Lena, Roma, Transfer.DEBIT, 1000 * i));
            } else if (i == 5) {
                list.add(new Transaction(UUID.fromString("4248be80-4823-483c-bd19-d42eecc5d901"), Lena, Roma, Transfer.DEBIT, 1000 * i));
            } else {
                list.add(Transaction.createTransaction(Lena, Roma, Transfer.CREDIT, -1000 * i));
            }
        }
        System.out.println(ANSI_GREEN + "PRINT LIST" + ANSI_RESET);
        list.printInfoLinkedList();

        list.remove("4248be80-4823-483c-bd19-d42eecc5d901");
        System.out.println(ANSI_GREEN + "PRINT LIST AFTER REMOVE" + ANSI_RESET);
        list.printInfoLinkedList();

        System.out.println(ANSI_GREEN + "PRINT LIST ARRAY" + ANSI_RESET);
        Transaction[] array = list.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].toString());
        }
    }
}
