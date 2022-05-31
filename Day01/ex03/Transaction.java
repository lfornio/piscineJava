import java.util.UUID;

public class Transaction {
    private UUID identifier;
    private User sender;
    private User recipient;
    private Transfer transferCategory;
    private Integer amount;

    public Transaction(UUID identifier, User sender, User recipient, Transfer transferCategory, Integer amount) {
        this.identifier = identifier;
        this.sender = sender;
        this.recipient = recipient;
        this.transferCategory = transferCategory;
        this.amount = amount;
    }

    private Transaction(User sender, User recipient, Transfer transferCategory, Integer amount) {
        this.identifier = UUID.randomUUID();
        this.sender = sender;
        this.recipient = recipient;
        this.transferCategory = transferCategory;
        this.amount = amount;
    }

    public static Transaction createTransaction(User sender, User recipient, Transfer transferCategory, Integer amount) {
        if (transferCategory == Transfer.CREDIT && amount < 0 || transferCategory == Transfer.DEBIT && amount > 0) {
            return new Transaction(sender, recipient, transferCategory, amount);
        } else {
            System.out.println("Transaction not created");
            return null;
        }
    }

    public void execute() {
        if (recipient.getBalance() < 0 || sender.getBalance() < 0) {
            System.out.println("User balance is negative");
            return;
        }
        switch (transferCategory) {
            case DEBIT:
                if (amount < 0) {
                    System.out.println("The transaction cannot be executed. For DEBIT amount < 0");
                    return;
                }
                if (recipient.getBalance() - amount >= 0) {
                    recipient.setBalance(recipient.getBalance() - amount);
                    sender.setBalance(sender.getBalance() + amount);
                } else {
                    System.out.println("The transaction cannot be executed. No money.");
                    return;
                }
                break;
            case CREDIT:
                if (amount > 0) {
                    System.out.println("The transaction cannot be executed. No money.");
                    return;
                }
                if (sender.getBalance() + amount >= 0) {
                    sender.setBalance(sender.getBalance() + amount);
                    recipient.setBalance(recipient.getBalance() - amount);
                } else {
                    System.out.println("The transaction cannot be executed. Sender - beggar");
                    return;
                }
                break;
        }
        System.out.println("The transaction is completed.");
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
                ", transferCategory=" + transferCategory +
                ", transferAmount=" + amount +
                '}';
    }
}

enum Transfer {
    DEBIT,
    CREDIT
}
