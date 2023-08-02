import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    
    public Order() {
        this.name = "Guest";
        this.items = new ArrayList<>(); 
        this.ready = false; 
    }

      public Order(String name) {
        this.name = name;
        this.items = new ArrayList<>(); 
        this.ready = false; 
    }


    public void addItem(Item item) {
        items.add(item); 
        // item.getPrice(); 
    }

    public String getStatusMessage() {
        if (ready) {
            return "Your order is ready.";
        } else {
            return "Thank you for waiting. Your order will be ready soon.";
        }
    }

    public double getOrderTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }

    public void display() {
        System.out.println("Customer Name: " + name);
        for (Item item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + getOrderTotal());
    }













    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Boolean getReady() {
        return this.ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public ArrayList<Item> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


}
