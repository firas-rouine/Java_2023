import java.util.ArrayList;

public class Order {
    public String name;
    public double total;
    public boolean ready;
    public ArrayList<Item> items;

    
    public Order() {
        this.name = null;
        this.items = new ArrayList<>(); 
        this.total = 0.0;
        this.ready = false; 
    }
}
