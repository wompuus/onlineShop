package runningShop;

import java.util.Scanner;


public class Run {


    private Scanner scanner;

    MenuOptions optionSelection;
    //This is the contructor used to create this class from App.java
    Run(Scanner scanner){
        this.scanner = scanner;
    }

//Main running profile of the class, we will loop back to this to decide what to do
    public void startRun(){
        System.out.println("Welcome");
        printMenu();
        optionSelection = getNextOptionFromUser();
        while (optionSelection != MenuOptions.EXIT_MENU) {
            if(optionSelection == MenuOptions.IS_EVEN){
                System.out.println("Please Enter a Number To Check.");
                isEven(getNextIntFromUser());
            }
            if(optionSelection == MenuOptions.PERFECT_SQUARE){
                System.out.println("Please Enter a Number To Check.");
                perfectSquare(getNextIntFromUser());
            }
            returnToMenu();
        }
        exit();
    }

    private void printMenu(){
        System.out.println("--Menu--");
        for(MenuOptions option: MenuOptions.values()){
            System.out.println("ID: " + option.getId() + " " +  option.getDisplayValue());
        }
    }
//Method to check if a number is even or odd.
    public void perfectSquare(int pSquare){
        if(pSquare >= 0){ 
            int sr = (int)Math.sqrt(pSquare);
            if ((sr * sr) == pSquare) {
                System.out.println("This is a perfect Square");
            } else {
                System.out.println("This is not a perfect Square.");
            }
        }
    }
//Method used to check if a number input is even or odd.
    public void isEven(int numberToCheck){
        if((numberToCheck % 2) == 0 ) { 
            System.out.println("The number was even!");
        } else {
            System.out.println("The number is odd");
        }
    }
//Method used to return to the menu
    private void returnToMenu(){
        System.out.println("Press Y to return to menu. Press N to exit.");
        String checkYesOrNo = (getNextStringFromUser().toUpperCase());
        if (checkYesOrNo.equals("Y")) {
            printMenu();
            optionSelection = getNextOptionFromUser();
        } else if(checkYesOrNo.equals("N")){
            exit();
        } else {
            System.out.println("Please input either Y or N.");
            returnToMenu();
        }

    }
//Method to get the next MenuOption enum to plug into the menu.
    private MenuOptions getNextOptionFromUser(){
        return MenuOptions.fromOptionId(getNextIntFromUser());
    }
//Method to exit program
    private void exit(){
        System.out.println("Exiting Now");
        scanner.close();
        System.exit(0);
    }
//Method to get next int input from user
    private int getNextIntFromUser(){
        return scanner.nextInt();
    }
//Method to get next string input from user
    private String getNextStringFromUser(){
        scanner.nextLine();
        return scanner.nextLine();
    }
}
