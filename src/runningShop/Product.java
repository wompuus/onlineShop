package runningShop;


public class Product {
   
    private String name;
    private double price;
    private int id;
    
    Product(int id, String name, double price) {
        this.name = name;
        this.price = price;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getID() {
        return id;
    }
}
