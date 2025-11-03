package HW12;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Arrays;
import java.util.List;

public class DataCreation {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US); // Set default locale for consistent number formatting

        
        List<Account> accountList = Arrays.asList(
            new Account(100, "Alan Jones", 348.17),
            new Account(300, "Mary Smith", 27.19),
            new Account(500, "Sam Sharp", 0.00),
            new Account(700, "Suzy Green", -14.22)
        );

      // Create a list of TransactionRecord objects
        List<TransactionRecord> transactionList = Arrays.asList(
            new TransactionRecord(100, 27.14),
            new TransactionRecord(300, 62.11),
            new TransactionRecord(400, 100.56),
            new TransactionRecord(900, 82.17)
        );

       // Write accounts and transactions to their respective files
        try (PrintWriter masterFile = new PrintWriter("oldmast.txt");
             PrintWriter transactionFile = new PrintWriter("trans.txt")) {

   
            for (Account account : accountList) {
                masterFile.printf("%d %s %.2f%n", account.getAccountNum(), account.getCustName(), account.getBalance());
            }

            // Write transaction data to trans.txt
            for (TransactionRecord transaction : transactionList) {
                transactionFile.printf("%d %.2f%n", transaction.getAccountNum(), transaction.getAmount());
            }

        } catch (Exception e) {
            System.out.println("An error occurred while creating data files: " + e.getMessage());
        }
    }
}
