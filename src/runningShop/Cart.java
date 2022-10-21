package runningShop;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Product> items = new ArrayList<>();
    private double total;
    private double taxRate = 10.00;
    private StringBuilder sb = new StringBuilder();
    
    public void addItem(Product p) {
        if (p != null) { 
            items.add(p);
            System.out.println(String.format("%s has been added to your cart.", p.getName()));
        }
    }
    public void showDetails() {
        if (items.size() > 0) {   
            double preTaxTotal = 0.00;
            System.out.println("--Cart--");
            System.out.println("Item Count: " + items.size());
            System.out.println("Items:");
            for (Product product: items) {
                String printItems = String.format("%s: $%.2f", product.getName(), product.getPrice());
                System.out.println(printItems);
                preTaxTotal += product.getPrice();
            }
            String cost = String.format("Pre-Tax Total: $%.2f", preTaxTotal);
            System.out.println();
            System.out.println(cost);
            total = preTaxTotal;
            double taxMultiplier = taxRate / 100;
            double taxToAdd = taxMultiplier * total;
            total += taxToAdd;
            String totalCost = String.format("Post-Tax Total (%.2f%% Tax): $%.2f", taxRate, total);
            System.out.println(totalCost);
        } else { 
            System.out.println("The cart is empty. Please add at least one product to see it in the cart.");
        }
    }
    public boolean checkout() {
        double preTaxTotal = 0.00;
        if (items.size() > 0) {
        
            for (Product product: items) { 
                preTaxTotal += product.getPrice();
            }
            total = preTaxTotal;
            double taxMultiplier = taxRate / 100;
            double taxToAdd = taxMultiplier * total;
            total += taxToAdd;
            String totalCost = String.format("Your total is $%.2f", total);
            System.out.println(totalCost);
            System.out.println("Thank you for shopping at T-Shirt Mart.");
            items.clear();
            return true;  
        } else {

            System.out.println("Your cart is currently empty. Please add at least one product to check out.");
            return false;
        }
    }
}
