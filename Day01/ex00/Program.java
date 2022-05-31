public class Program {
    public static void main(String[] args) {
        User Sveta = new User("Sveta", -5000);
        System.out.println(Sveta.toString());

        User Lena = new User("Lena", 5000);
        User Roma = new User("Roma", 2000);
        System.out.println(Lena.toString());
        System.out.println(Roma.toString());

        Transaction transaction = Transaction.createTransaction(Lena, Roma, Transfer.CREDIT, 10000);
        if (transaction != null) {
            System.out.println(transaction.toString());
        }

        Transaction transaction_2 = Transaction.createTransaction(Lena, Roma, Transfer.CREDIT, -10000);
        if (transaction_2 != null) {
            System.out.println(transaction_2.toString());
        }

        Transaction transaction_3 = Transaction.createTransaction(Lena, Roma, Transfer.DEBIT, 10000);
        if (transaction_3 != null) {
            System.out.println(transaction_3.toString());
        }
        Transaction transaction_4 = Transaction.createTransaction(Lena, Roma, Transfer.DEBIT, -10000);
        if (transaction_4 != null) {
            System.out.println(transaction_4.toString());
        }
    }
}
