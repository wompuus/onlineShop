package runningShop;

import java.util.Scanner;

public class Menu {
    private String[] menuOptions = {"Exit", "List Products", "Buy Product", "Find Product", "Show Cart", "Checkout"};
    private Scanner scanner;
    private Shop shop;
    private Cart cart = new Cart();
    public Menu(Scanner scanner, Shop shop) {
        this.scanner = scanner;
        this.shop = shop;
    }



    public void executeMenu() {
        printMenu();
        MenuOption optionSelection = getNextOptionFromUser();
        while (optionSelection != MenuOption.EXIT) {
            handleShopperMenuOptionSelection(optionSelection);
            printMenu();    
            optionSelection = getNextOptionFromUser();
        }
        exit();
    }
    
    private void handleShopperMenuOptionSelection(MenuOption option){
                    if (option == MenuOption.LIST_PRODUCTS) {
                shop.printProducts();

            } else if (option == MenuOption.BUY_PRODUCT) {
                System.out.println("Please enter the ID of the product you would like to purchase:");
                int itemToAdd = getNextIntFromUser(); 
                Product addProduct = shop.addProduct(itemToAdd);
                addToCart(addProduct);
            
            } else if (option == MenuOption.FIND_PRODUCT) {
                System.out.println("Enter the item to search for:");
                String itemToFind = getNextStringLineFromUser();
                shop.findProduct(itemToFind);
                
            } else if (option == MenuOption.SHOW_CART) {
                cart.showDetails();

            } else if (option == MenuOption.CHECKOUT) {
                cart.checkout();

            }
    }
    public void greet() {
        System.out.println("Hello. Please enter your name:");
        String name = scanner.nextLine();
        String shopName = "T-Shirt Mart";
        System.out.println("Welcome " + name + " to " + shopName);
    }


    private void printMenu() {
        System.out.println();
        System.out.println("--Main Menu--");
        System.out.println("Select an option using one of the numbers shown");
        System.out.println();

        for (int i = 0; i < menuOptions.length; i++) {
            System.out.print(i + ": ");
            System.out.println(menuOptions[i]);
        }
    }
    private void addToCart(Product id) {
        cart.addItem(id);
    }

    private void exit() {
        System.out.println("Exiting now. Goodbye.");
        scanner.close();
    }

    private MenuOption getNextOptionFromUser() {
        return MenuOption.fromOptionId(getNextIntFromUser());
    }

    private int getNextIntFromUser() {
        return scanner.nextInt();
    }


    private String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }
}
