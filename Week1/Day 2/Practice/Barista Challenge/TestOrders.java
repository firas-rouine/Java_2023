public class TestOrders {
    public static void main(String[] args) {
        // Create 2 orders for unspecified guests (without specifying a name)
        Order order1 = new Order();
        Order order2 = new Order();

        // Create 3 orders using the overloaded constructor to give each a name for the order
        Order order3 = new Order("Cindhuri");
        Order order4 = new Order("Jimmy");
        Order order5 = new Order("Noah");

        // Create some Item objects
        Item item1 = new Item("drip coffee", 1.50);
        Item item2 = new Item("cappuccino", 3.50);
        Item item3 = new Item("mocha", 4.00);

        // Add at least 2 items to each of the orders using the addItem method
        order1.addItem(item1);
        order1.addItem(item2);

        order2.addItem(item1);
        order2.addItem(item3);

        order3.addItem(item2);
        order3.addItem(item3);

        order4.addItem(item1);
        order4.addItem(item2);

        order5.addItem(item1);
        order5.addItem(item3);

        
        order2.setReady(true);
        System.out.println(order2.getStatusMessage());

        System.out.println(order1.getOrderTotal());

        order1.display();
        order2.display();
        order3.display();
        order4.display();
        order5.display();
    }
}
