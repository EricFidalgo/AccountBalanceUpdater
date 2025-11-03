# Account Balance File Matching

## Project Description

This project is a simple batch processing system written in Java that manages bank account balances. It reads a master file of customer accounts and a file of recent transactions. The program updates the account balances based on the transactions and generates a new master file with the updated information. Any transactions for accounts that do not exist in the master file are recorded in a separate log file.

The process is as follows:

1.  `DataCreation.java` first generates two files:
    - `oldmast.txt`: A master file containing a list of accounts with their number, name, and current balance.
    - `trans.txt`: A transaction file containing account numbers and transaction amounts.
2.  `FileMatch.java` then reads the `oldmast.txt` file to load all existing accounts.
3.  It processes each record from `trans.txt`.
    - If a transaction's account number matches an existing account, the account's balance is updated.
    - If no match is found, the transaction is written to `log.txt`.
4.  Finally, all account data (with updated balances) is written to a new master file, `newmast.txt`.

## Technologies Used

- **Language:** Java
- **Core Libraries:**
  - `java.io` for file input/output operations (`BufferedReader`, `PrintWriter`, etc.).
  - `java.util` for data structures (`HashMap`, `List`, `Arrays`).

## How to Run

Follow these steps to compile and run the project from your terminal.

1.  **Compile the Java Files**

    ```bash
    javac *.java
    ```

2.  **Generate the Data Files**

    Run the `DataCreation` program to create `oldmast.txt` and `trans.txt`.

    ```bash
    java DataCreation
    ```

3.  **Run the File Matching Program**
    Execute the main `FileMatch` program to process the files and produce the final output.
    ```bash
    java FileMatch
    ```
4.  **Check the Output**
    After running, you will find two new files:
    - `newmast.txt`: Contains the updated account balances.
    - `log.txt`: Contains any transactions that did not have a matching account.

## Project Output

After running the program, two files are generated: `newmast.txt` with the updated account balances, and `log.txt` for any unmatched transactions.

### `newmast.txt`

This file contains the final state of all accounts after processing the transactions.

```plaintext
100 Alan Jones 375.31
500 Sam Sharp 0.00
300 Mary Smith 89.30
700 Suzy Green -14.22
```

> **Note:** The order of records in `newmast.txt` may vary because the program writes the data from a `HashMap`.

### `log.txt`

This file logs any transaction from `trans.txt` that did not have a matching account in `oldmast.txt`.

```plaintext
No match for transaction with account number: 400
No match for transaction with account number: 900
```
