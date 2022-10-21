package runningShop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.border.EtchedBorder;
import javax.swing.*;

public class ShopGui extends JFrame{
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 34);
    JTextField tfFirstName, tfLastName;
    JLabel lbWelcome;
    static ShopGui myFrame = new ShopGui();
    JPanel mainPanel = new JPanel();


    public void initialize(){
        /**************** Form Panel *****************/
        JLabel lbShopWelcome = new JLabel("Welcome To The Shop!", SwingConstants.CENTER);
        lbShopWelcome.setFont(mainFont);


        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1, 5, 5));
        formPanel.setOpaque(false);
        formPanel.add(lbShopWelcome);

        /*******************Welcome Label**************/
        lbWelcome = new JLabel();
        lbWelcome.setFont(mainFont);
        

        /*******************Buttons Panel**************/
        JButton btnEnter = new JButton("Enter Here");
        btnEnter.setFont(mainFont);
        btnEnter.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                myFrame.insideShop();
                myFrame.remove(mainPanel);
                
            }

        });
        

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 1, 5, 5));
        buttonsPanel.setOpaque(false);
        buttonsPanel.add(btnEnter);


        
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(128, 128, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);
        
        setTitle("Shop");
        setSize(500,500);
        setMinimumSize(new Dimension(300,400));
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }



    public void insideShop(){
    // Adding the list of options from MenuOption enum to an array of buttons
        ArrayList<JButton> buttons = new ArrayList<>();
        for (MenuOption option : MenuOption.values()) {
            buttons.add(new JButton(option.getDisplayValue()));

        }
    //Creating the button panel to add to the main shop area
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.PAGE_AXIS));
        buttonsPanel.setOpaque(false);
    //Customing each button that was added from the MenuOption enum
        for (JButton button : buttons){
            button.setBackground(Color.red);
            button.setFont(mainFont);
            button.setPreferredSize(new Dimension(10, 40));
            Font newButtonFont  = new Font(button.getFont().getName(),button.getFont().getStyle(),12);
            //Set JButton font using new created font
            button.setFont(newButtonFont);
            button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

            }

        });
        //adding the buttons to the buttons panel
        buttonsPanel.add(button);
        }
        JPanel firstGluePanel = new JPanel(new BorderLayout());
        firstGluePanel.add(Box.createHorizontalGlue(), BorderLayout.WEST);
        firstGluePanel.add(Box.createVerticalGlue(), BorderLayout.NORTH);
        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(255, 128, 255));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(firstGluePanel);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);

        add(mainPanel);
        setTitle("Shop");
        setSize(500,500);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        myFrame.initialize();
    }
}
