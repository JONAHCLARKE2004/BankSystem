
/**
 * This class has the functions that allow the user to 
 * input and save account details to the BankSystem.
 * 
 *
 * @author 50069063 Jonah Clarke
 * @version 18.0.1.1 11/03/2024
 */



public class Account {
    private static int numAccounts = 0;
    private int accountNumber;
    private String accountName;
    private String accountType;
    private String address;
    private double accountBalance;
    private String sortCode;
    private double overdraftLimit;

    /**
     *
     * @param accountNumber
     * @param accountName
     * @param accountType
     * @param address
     * @param accountBalance
     * @param sortCode
     * @param overdraftLimit
     */
    public Account(int accountNumber, String accountName, String accountType, String address, double accountBalance,
               String sortCode, double overdraftLimit) {
    this.accountNumber = accountNumber;
    this.accountName = accountName;
    this.accountType = accountType;
    this.address = address;
    this.accountBalance = accountBalance;
    this.sortCode = sortCode;
    this.overdraftLimit = overdraftLimit;
}

    /**
     *
     * @param account
     */
    public Account(Account account) {
        this.accountNumber = account.accountNumber;
        this.accountName = account.accountName;
        this.accountType = account.accountType;
        this.address = account.address;
        this.accountBalance = account.accountBalance;
        this.sortCode = account.sortCode;
        this.overdraftLimit = account.overdraftLimit;
    }

    
    //getters and setters

    /**
     *
     * @return
     */
    public int getAccountNumber() {
        return accountNumber;
    }
    
    /**
     *
     * @param accountNumber
     */
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    /**
     *
     * @return
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     *
     * @param accountName
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     *
     * @return
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     *
     * @param accountType
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     *
     * @param accountBalance
     */
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     *
     * @return
     */
    public String getSortCode() {
        return sortCode;
    }

    /**
     *
     * @param sortCode
     */
    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    /**
     *
     * @return
     */
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     *
     * @param overdraftLimit
     */
    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    /**
     *
     * @return
     */
    public static int getNumAccounts() {
        return numAccounts;
    }

    //Account Details

    /**
     *
     */
    public void printDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Name: " + accountName);
        System.out.println("Account Type: " + accountType);
        System.out.println("Address: " + address);
        System.out.println("Account Balance: " + "\u00A34" + accountBalance);
        System.out.println("Sort Code: " + sortCode);
        System.out.println("Overdraft Limit: £" + overdraftLimit);
    }

    
    //couldn't get the pound sign to print correctly, apparently doing the whole "\u00A34" ting would make it display but it ain't happening :)
    
    
    //Deposit and Withdraw functions

    /**
     *
     * @param amount
     */
    public void deposit(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    /**
     *
     * @param amount
     */
    public void withdraw(double amount) {
        if (amount > 0) {
            if (accountBalance - amount >= -overdraftLimit) {
                accountBalance -= amount;
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Withdrawal amount exceeds overdraft limit.");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
