import java.util.ArrayList;
import java.util.Scanner;

public class CafeUtil {
    public int getStreakGoal(int number) {
        int sums = 0;
        for (int i = 0; i <= number; i++)
            sums += i;
        return sums;

    }

    public double getOrderTotal(double[] prices) {
        float sum = 0;
        for (int i = 0; i < prices.length; i++)
            sum += prices[i];
        return sum;

    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(i + " " + menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        int numAhead = customers.size();
        customers.add(userName);
        System.out.println(String.format("Hello,%s! ,there are %d people ahead of you", userName, numAhead));
        System.out.println(customers);

    }

    public void printPriceChart(String product, double price, int maxQuantity) {
        System.out.println(product);
        for (int i = 1; i <= maxQuantity; i++) {
            System.out.println(String.format("%d - $%.2f", i, price * i));
        }
    }
    public static boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
        if (menuItems.size() != prices.size()) {
            return false;
        }

        for (int i = 0; i < menuItems.size(); i++) {
            String menuItem = menuItems.get(i);
            double price = prices.get(i);
            System.out.printf("%d %s -- $%.2f\n", i, menuItem, price);
        }

        return true;
    }
    public static void addCustomers(ArrayList<String> customers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer names. Type 'q' when you are finished.");

        String input;
        while (true) {
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            customers.add(input);
        }

        System.out.println("Customer names entered: " + customers);
    }
}