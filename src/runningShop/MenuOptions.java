package runningShop;

public enum MenuOptions {
    EXIT_MENU(0, "Exit Menu"),
    IS_EVEN(1, "Check to see if even or odd"),
    PERFECT_SQUARE(2, "Check to see if number is a perfect square.");
    
    private int id;
    private String displayValue;

    MenuOptions(int id, String displayValue){
        this.id = id;
        this.displayValue = displayValue;
    }

    public static MenuOptions fromOptionId(int optionId){
        for(MenuOptions option: MenuOptions.values()){
            if (option.id == optionId) {
                return option;
            }
    }
                    throw new IllegalArgumentException(String.format("Menu option id %d is not an available option.", optionId));
    }

    public String getDisplayValue(){
        return displayValue;
    }

    public int getId(){
        return id;
    }
}
