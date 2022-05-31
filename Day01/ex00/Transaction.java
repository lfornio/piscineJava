import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User sender;
    private User recipient;
    private Transfer transferCategory;
    private Integer amount;

    private Transaction(User sender, User recipient, Transfer transferCategory, Integer amount) {
        this.identifier = UUID.randomUUID();
        this.sender = sender;
        this.recipient = recipient;
        this.transferCategory = transferCategory;
        this.amount = amount;
    }

    public static Transaction createTransaction(User sender, User recipient, Transfer transferCategory, Integer amount) {
        if (transferCategory == Transfer.CREDIT && amount < 0 || transferCategory == Transfer.DEBIT && amount > 0) {
            System.out.println("Transaction created");
            return new Transaction(sender, recipient, transferCategory, amount);
        } else {
            System.out.println("Transaction not created");
            return null;
        }
    }

    public UUID getIdentifier() {
        return identifier;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public Transfer getTransferCategory() {
        return transferCategory;
    }

    public Integer getTransferAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "identifier=" + identifier +
                ", recipient=" + recipient +
                ", sender=" + sender +
                ", transferCategory=" + transferCategory +
                ", transferAmount=" + amount +
                '}';
    }
}

enum Transfer {
    DEBIT,
    CREDIT
}
