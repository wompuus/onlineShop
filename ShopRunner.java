package runningShop;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * The ShopRunner class is the main entry point for the application.
 * It encapsulates a Menu, providing it with a Scanner configured
 * with System.in to allow the menu to read from standard in.
 * When the application starts, the menu's greet and show methods are called.
 */
public class ShopRunner {
    
    /**
     * Main entry point to the application.
     * Asks the menu's greeting to be printed to standard out by calling its greet method.
     * Asks the menu to be shown by calling its show method.
     * @param args Command line arguments to the application
     */
    public static void main(@Nullable String[] args) { 
        Product product0 = new Product(0, "Crew Neck", 20.00);
        Product product1 = new Product(1, "V-Neck", 20.00);
        Product product2 = new Product(2, "Polo", 25.50);
        Product product3 = new Product(3, "Boat Neck", 30.25); 
        Product product4 = new Product(4, "Tank Top", 15.75);
        ArrayList<Product> shopProducts = new ArrayList<Product>(
            Arrays.asList(product0, product1, product2, product3, product4)
        );
        Shop shop = new Shop(shopProducts);
        Menu menu = new Menu(new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8"))), shop);
        menu.greet();
        menu.executeMenu();
    }
}
