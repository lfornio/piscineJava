public class TransactionsLinkedList implements TransactionsList {
    private Node head;
    private Node tail;
    private static Integer sizeList;

    public TransactionsLinkedList() {
        this.head = null;
        this.tail = null;
        sizeList = 0;
    }

    @Override
    public void add(Transaction transaction) {
        Node newNode = new Node(transaction);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        sizeList++;
    }

    @Override
    public void remove(String uuid) {
        if (head == null) {
            return;
        }
        if (head.transaction.getIdentifier().toString().equals(uuid)) {
            head = head.next;
            sizeList--;
            return;
        }
        Node tmp = head;
        while (tmp.next != null) {
            if (tmp.next.transaction.getIdentifier().toString().equals(uuid)) {
                tmp.next = tmp.next.next;
                sizeList--;
                return;
            }
            tmp = tmp.next;
        }
        throw new TransactionNotFoundException();
    }


    @Override
    public Transaction[] toArray() {
        Transaction[] result = new Transaction[sizeList];
        int i = 0;
        Node tmp = head;
        while (tmp != null) {
            result[i++] = tmp.transaction;
            tmp = tmp.next;
        }
        return result;
    }

    public static Integer getSizeList() {
        return sizeList;
    }

    public void printInfoLinkedList() {
        System.out.println("size = " + sizeList);
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.transaction.toString());
            tmp = tmp.next;
        }
    }

    class Node {
        private Transaction transaction;
        private Node next;

        public Node(Transaction transaction) {
            this.transaction = transaction;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "transaction=" + transaction +
                    ", next=" + next +
                    '}';
        }
    }


}
