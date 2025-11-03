package HW12;

public class TransactionRecord {
    private int accountNumber;
    private double amount;

    public TransactionRecord(int accountNum, double amount) {
        this.accountNumber = accountNum;
        this.amount = amount;
    }

    public int getAccountNum() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }
}
