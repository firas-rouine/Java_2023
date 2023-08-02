import java.util.Random;

public class BankAccount {
    private static int numAccounts;
    private static double totalAmount;
    private String accountNumber;

    private double checkingBalance;
    private double savingsBalance;
   
    public BankAccount(){
        this.checkingBalance=0.0;
        this.savingsBalance=0.0;
        numAccounts++;
        this.accountNumber = generateAccountNumber();
    }

    public void deposit(double amount, String accountType) {
        if (accountType.equalsIgnoreCase("checking")) {
            checkingBalance += amount;
        } else if (accountType.equalsIgnoreCase("savings")) {
            savingsBalance += amount;
        }
        totalAmount += amount;
    }

    public void withdraw(double amount, String accountType) {
        if (accountType.equalsIgnoreCase("checking")) {
            if (checkingBalance >= amount) {
                checkingBalance -= amount;
                totalAmount -= amount;
            } else {
                System.out.println("Insufficient funds in checking account.");
            }
        } else if (accountType.equalsIgnoreCase("savings")) {
            if (savingsBalance >= amount) {
                savingsBalance -= amount;
                totalAmount -= amount;
            } else {
                System.out.println("Insufficient funds in savings account.");
            }
        }
    }
        // Private method to generate a random ten-digit account number
    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNum = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            accountNum.append(random.nextInt(10));
        }
        return accountNum.toString();
    }

    public double getTotalMoney() {
        return this.checkingBalance + this.savingsBalance;
    }
    

    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    //    public void  setCheckingBalance(double checkingBalance){
    //      this.checkingBalance =checkingBalance;
    // }
       public double getSavingsBalance(){
        return this.savingsBalance;
    }
    //    public void  setSavingsBalance(double savingsBalance){
    //      this.savingsBalance =savingsBalance;
    // }
    public static int getNumAccounts() {
        return numAccounts;
    }

    public static double getTotalAmount() {
        return totalAmount;
    }
}