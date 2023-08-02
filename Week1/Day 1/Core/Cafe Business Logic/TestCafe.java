import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args) {

        /*
         * You will need add 1 line to this file to create an instance
         * of the CafeUtil class.
         * Hint: it will need to correspond with the variable name used below..
         */

        /* ============ App Test Cases ============= */
        CafeUtil appTest = new CafeUtil();

        System.out.println("\n----- Streak Goal Test -----");
        System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal(10));

        System.out.println("----- Order Total Test-----");
        double[] lineItems = { 3.5, 1.5, 4.0, 4.5 };
        System.out.printf("Order total: %s \n\n", appTest.getOrderTotal(lineItems));

        System.out.println("----- Display Menu Test-----");

        ArrayList<String> menu = new ArrayList<String>();
        menu.add("drip coffee");
        menu.add("cappuccino");
        menu.add("latte");
        menu.add("mocha");
        appTest.displayMenu(menu);

        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> customers = new ArrayList<String>();
        // --- Test 4 times ---
        for (int i = 0; i < 4; i++) {
            appTest.addCustomer(customers);
            System.out.println("\n");
        }

        System.out.println("\n----- overload the display menu-----");
        appTest.printPriceChart("Columbian Coffee Grounds", 15, 3);

        System.out.println("\n----- Add Customer Test-----");
        ArrayList<String> menuItems = new ArrayList<>();
        menuItems.add("drip coffee");
        menuItems.add("cappucino");
        menuItems.add("latte");
        menuItems.add("mocha");

        ArrayList<Double> prices = new ArrayList<>();
        prices.add(1.50);
        prices.add(3.50);
        prices.add(4.50);
        prices.add(3.50);

        boolean success = appTest.displayMenu(menuItems, prices);

        if (!success) {
            System.out.println("The menuItems and prices arrays must have the same size.");
        }

        System.out.println("\n----- Add Customer -----");

        ArrayList<String> customerList = new ArrayList<>();
        appTest.addCustomers(customerList);
    }
}
