public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();

        account1.deposit(1000, "checking");
        account1.deposit(500, "savings");
        account2.deposit(2000, "checking");

        System.out.println("Account 1 - Checking Balance: $" + account1.getCheckingBalance());
        System.out.println("Account 1 - Savings Balance: $" + account1.getSavingsBalance());
        System.out.println("Account 2 - Checking Balance: $" + account2.getCheckingBalance());

        account1.withdraw(300, "checking");
        account1.withdraw(200, "savings");

        System.out.println("Account 1 - Total Money: $" + account1.getTotalMoney());
        System.out.println("Account 2 - Total Money: $" + account2.getTotalMoney());

        System.out.println("Number of Accounts: " + BankAccount.getNumAccounts());
        System.out.println("Total Amount in All Accounts: $" + BankAccount.getTotalAmount());
    }
}
