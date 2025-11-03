package HW12;

public class Account {
    private int accountNumber;
    private String customerName;
    private double balanceAmount;

    public Account(int accountNum, String custName, double balance) {
        this.accountNumber = accountNum;
        this.customerName = custName;
        this.balanceAmount = balance;
    }

    public int getAccountNum() {
        return accountNumber;
    }

    public void setAccountNum(int accountNum) {
        this.accountNumber = accountNum;
    }

    public String getCustName() {
        return customerName;
    }

    public void setCustName(String custName) {
        this.customerName = custName;
    }

    public double getBalance() {
        return balanceAmount;
    }

    public void setBalance(double balance) {
        this.balanceAmount = balance;
    }

    // Update the account balance with transaction details
    public void updateBalance(TransactionRecord transaction) {
        this.balanceAmount += transaction.getAmount();
    }
}
