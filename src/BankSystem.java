import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class displays the prints, inputs and outputs 
 * for the BankSystem to the user.
 * 
 * Input: User is given a menu where from there they can, show accounts
 * create accounts, deposit, withdraw and exit the program.
 * For the menu options the user has to input a number from 1-5.
 * Other sections are based on what the system prompts the user to do.
 * If user enters a invalid input the system will display a error
 * and make the user repeat the task.
 * 
 * Output: Account details, cash in balance, menu options and error messages.
 * 
 * 
 * Libraries Used: Scanner from java.util
 *                 ArrayList from java.util
 * 
 * @author 50069063 Jonah Clarke
 * @version 18.0.1.1 11/03/2024
 */


public class BankSystem {

    /**
     *
     */
    private static final ArrayList<Account> accounts = new ArrayList<>();

    /**
     *
     */
    private static final Scanner scanner = new Scanner(System.in);

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
        //Accounts in system
        accounts.add(new Account(11111111, "Person1", "Personal", "123 Main St, City", 1000.0, "11-22-33", 2000.0));
        accounts.add(new Account(22222222,"Person2", "Business", "456 Left St, Town", 50000.0, "44-55-66", 5000.0));
	accounts.add(new Account(33333333,"Person3", "Personal", "798 Down Town, City", 2000.0, "55-88-99", 1000.0));
        accounts.add(new Account(44444444,"Person4", "Business", "999 Up Hill, Town", 50000.0, "87-56-23", 4000.0));
	accounts.add(new Account(55555555,"Person5", "Personal", "321 Right St, City", 1500.0, "33-22-11", 2500.0));
	accounts.add(new Account(66666666,"Person6", "Business", "789 Backwards Ave, Town", 75000.0, "66-55-44", 6000.0));
	accounts.add(new Account(77777777,"Person7", "Personal", "654 Fowards St, City", 3000.0, "99-88-77", 2000.0));
	accounts.add(new Account(888888888,"Person8", "Business", "234 No Motivation Ave, Town", 60000.0, "23-45-67", 7000.0));
	accounts.add(new Account(999999999,"Person9", "Personal", "876 London, City", 2500.0, "11-33-55", 1500.0));
	accounts.add(new Account(12121212,"Person10", "Business", "432 Testing Ave, Town", 55000.0, "77-99-11", 8000.0));
	accounts.add(new Account(23232323,"Person11", "Personal", "567 Belfast, City", 1800.0, "88-77-99", 2700.0));
	accounts.add(new Account(34343434,"Person12", "Business", "123 Disaster Ave, Town", 65000.0, "22-66-88", 9000.0));
	accounts.add(new Account(45454545,"Person13", "Personal", "789 Paris, City", 2200.0, "44-11-77", 1300.0));
	accounts.add(new Account(56565656,"Person14", "Business", "456 Cash In Ave, Town", 70000.0, "99-33-22", 10000.0));
	accounts.add(new Account(67676767,"Person15", "Personal", "234 Rome, City", 2700.0, "55-88-11", 1800.0));
	accounts.add(new Account(78787878,"Person16", "Business", "876 Cash Out Ave, Town", 68000.0, "33-77-55", 12000.0));
	accounts.add(new Account(89898989,"Person17", "Personal", "321 New York, City", 1900.0, "11-22-44", 2800.0));
	accounts.add(new Account(90909090,"Person18", "Business", "567 This Is a Bank Ave, Town", 62000.0, "66-99-11", 9500.0));
	accounts.add(new Account(63636363,"Person19", "Personal", "999 Dublin, City", 2400.0, "88-77-22", 1600.0));
	accounts.add(new Account(42424242,"Person20", "Business", "432 This isn't a Bank Ave, Town", 59000.0, "55-33-99", 8500.0));
	accounts.add(new Account(84848484,"Person21", "Personal", "789 Toyko, City", 2300.0, "44-11-66", 1400.0));
	accounts.add(new Account(95959595,"Person22", "Business", "321 Lower Half Ave, Town", 72000.0, "99-33-55", 10500.0));
	accounts.add(new Account(79797979,"Person23", "Personal", "876 Sydney, City", 2600.0, "55-88-11", 1700.0));
	accounts.add(new Account(25252525,"Person24", "Business", "654 Money Ave, Town", 64000.0, "33-77-22", 11000.0));
	accounts.add(new Account(14141414,"Person25", "Business", "777 Vegas, City", 77000.0, "77-77-22", 77000.0));

        
        //Menu
        try (scanner) {
            int choice;
            do {
                System.out.println("                          OOP (NI) Bank");
                System.out.println(" ");
                System.out.println("                          Account Menu");
                System.out.println(" ");
                System.out.println("1. Display All Account Details" +"        4. Deposit");
                System.out.println("2. Display Single Account details" +"     5. Withdraw");
                System.out.println("3. Add New Account"+ "                    6. Exit");
                
                
                 System.out.println("");
                System.out.println("Please enter menu choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> displayAllAccounts();
                    case 2 -> displaySingleAccount();
                    case 3 -> addNewAccount();
                    case 4 -> deposit();
                    case 5 -> withdraw();
                    case 6 -> System.out.println("Exiting program...");
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 6);
        }
    }

    
    //menu options

    /**
     *
     */
    private static void displayAllAccounts() {
        System.out.println("All Account Details:");
        for (Account account : accounts) {
            account.printDetails();
            System.out.println();
        }
        
    }

    /**
     *
     */
    private static void displaySingleAccount() {
        System.out.print("Enter account number: ");
        int accNumber = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Account account : accounts) {
            if (account.getAccountNumber() == accNumber) {
                account.printDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Account not found.");
        }
    }

    /**
     *
     */
    private static void addNewAccount() {
        
         System.out.print("Enter account number (8 digits) : ");
    String accNumber = scanner.nextLine();


    while (!accNumber.matches("\\d{8}")) {
        System.out.println("Invalid input. Account number must be 8 digits.");
        System.out.print("Enter account number (8 digits) : ");
        accNumber = scanner.nextLine();
    }

    int accountNumber = Integer.parseInt(accNumber);
    
        
        
        
        String name = "";
        while (name.isEmpty()) {
            System.out.print("Enter account name: ");
            name = scanner.nextLine();
            if (name.isEmpty()) {
                System.out.println("Invalid input. Account name cannot be empty.");
            }
        }

        System.out.print("Enter account type (Personal/Business): ");
        String type = "";
        while (!type.equalsIgnoreCase("Personal") && !type.equalsIgnoreCase("Business")) {
            type = scanner.nextLine();
            if (!type.equalsIgnoreCase("Personal") && !type.equalsIgnoreCase("Business")) {
                System.out.println("Invalid input. Please enter either 'Personal' or 'Business'.");
            }
        }

        String address = "";
        while (address.isEmpty()) {
            System.out.print("Enter address: ");
            address = scanner.nextLine();
            if (address.isEmpty()) {
                System.out.println("Invalid input. Address cannot be empty.");
            }
        }

        System.out.print("Enter initial balance: ");
        double balance = 0;
        while (true) {
            try {
                balance = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for balance.");
            }
        }

        System.out.print("Enter sort code (00-00-00): ");
        String sortCode = "";
        while (!sortCode.matches("\\d{2}-\\d{2}-\\d{2}")) {
            sortCode = scanner.nextLine();
            if (!sortCode.matches("\\d{2}-\\d{2}-\\d{2}")) {
                System.out.println("Invalid input. Please enter in the format 00-00-00.");
            }
        }

        System.out.print("Enter overdraft limit: ");
        double overdraftLimit = 0;
        while (true) {
            try {
                overdraftLimit = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for overdraft limit.");
            }
        }
        
        Account newAccount = new Account(accountNumber, name, type, address, balance, sortCode, overdraftLimit);
    accounts.add(newAccount);
        System.out.println("Account added successfully.");
    }

    /**
     *
     */
    private static void deposit() {
    System.out.print("Enter account number: ");
    int accNumber = 0;
    try {
        accNumber = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Invalid account number format. Please enter a valid account number.");
        return;
    }

    //debug code
//    System.out.println("Entered account number: " + accNumber);

    boolean found = false;
    for (Account account : accounts) {

        if (account.getAccountNumber() == accNumber) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); 
            account.deposit(amount);
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Account not found.");
    }
}

    /**
     *
     */
    private static void withdraw() {
    System.out.print("Enter account number: ");
    int accNumber = 0;
    try {
        accNumber = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.println("Invalid account number format. Please enter a valid account number.");
        return;
    }

    System.out.println("Entered account number: " + accNumber);

    boolean found = false;
    for (Account account : accounts) {
        if (account.getAccountNumber() == accNumber) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();
            account.withdraw(amount);
            found = true;
            break;
        }
    }
    if (!found) {
        System.out.println("Account not found.");
    }
}
}

