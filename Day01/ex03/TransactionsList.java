import java.util.UUID;

public interface TransactionsList {
    public void add(Transaction transaction);

    public void remove(String uuid);

    public Transaction[] toArray();
}
