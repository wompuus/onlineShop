package runningShop;

import java.util.ArrayList;

public class Shop {
    private String name;
    private ArrayList<Product> products;
    
    Shop(ArrayList<Product> userProducts) {
        products = userProducts;
    }
    
    public void printProducts() {
        System.out.println("--Products--");
        for (Product product: products) {
            System.out.println("ID " + product.getID() + ": " + product.getName() + " - $" + product.getPrice());   
        }
    }
    
    public void findProduct(String searchText) {
        int productID = -1;
        for (Product product: products) {
            if (searchText.equals(product.getName())) {
                System.out.println(product.getName() + 
                    " was found and its product id is " + product.getID());
                productID = 1;
                break;
            } 
        } 
        if (productID == -1) {
            System.out.println("That product was not found.");
        }
    }
    
   
    public Product addProduct(int id) {
        int productID = -1;
        for (Product product: products) {
            if (id == product.getID()) {
                productID = 1;
                return product;
            } 
        } 
        if (productID == -1) {
            System.out.println("That item ID is invalid and could not be added to the cart.");
            
        }
        return null;
    }
}
