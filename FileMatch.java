package HW12;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileMatch {
    private Map<Integer, Account> accounts = new HashMap<>();  // Map to store accounts by account number

    public void execute() {
        loadMasterFile();       // Load accounts from master file
        processTransactions();  // Process transaction records
        saveNewMasterFile();    // Save updated accounts to new master file
    }

    private void loadMasterFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("oldmast.txt"))) {
            String record;
            // Read each account record from oldmast.txt
            while ((record = reader.readLine()) != null) {
                String[] data = record.trim().split("\\s+");
                int acctNum = Integer.parseInt(data[0]);                // Parse account number
                String name = extractName(record);                      // Extract customer name
                double balance = Double.parseDouble(data[data.length - 1]);  // Parse balance amount

                // Create Account object and add it to the map
                accounts.put(acctNum, new Account(acctNum, name, balance));
            }
        } catch (IOException e) {
            System.out.println("Error reading master file: " + e.getMessage());
        }
    }

    private String extractName(String record) {
        // Extract the customer name from the record string
        return record.substring(record.indexOf(' ') + 1, record.lastIndexOf(' ')).trim();
    }

    private void processTransactions() {
        try (BufferedReader transReader = new BufferedReader(new FileReader("trans.txt"));
             PrintWriter logger = new PrintWriter("log.txt")) {
            String transRecord;
            // Read each transaction record from trans.txt
            while ((transRecord = transReader.readLine()) != null) {
                String[] transData = transRecord.split("\\s+");
                int acctNum = Integer.parseInt(transData[0]);    // Parse account number
                double amount = Double.parseDouble(transData[1]);  // Parse transaction amount
                Account account = accounts.get(acctNum);         // Get the account from the map
                
                if (account != null) {
                    // Update account balance if account exists
                    account.updateBalance(new TransactionRecord(acctNum, amount));
                } else {
                    // Log unmatched transactions
                    logger.printf("No match for transaction with account number: %d%n", acctNum);
                }
            }
        } catch (IOException e) {
            System.out.println("Error processing transactions: " + e.getMessage());
        }
    }

    private void saveNewMasterFile() {
        try (PrintWriter masterWriter = new PrintWriter("newmast.txt")) {
            // Write updated account data to newmast.txt
            accounts.values().forEach(
                (account) -> masterWriter.printf("%d %s %.2f%n", account.getAccountNum(), account.getCustName(), account.getBalance()));
        } catch (FileNotFoundException e) {
            System.out.println("Error writing new master file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new FileMatch().execute();  // Run the file matching process
    }
}
