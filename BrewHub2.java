import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BrewHub2{
 
    public static void main (String [] args){
       

        JFrame BrewHubFrame= new JFrame();
        BrewHubFrame.setTitle("BrewHub online Coffee Order System"); 
        BrewHubFrame.setSize(500, 500); 
        BrewHubFrame.setDefaultCloseOperation(BrewHubFrame.EXIT_ON_CLOSE);
        BrewHubFrame.setLocationRelativeTo(null);
        BrewHubFrame.setLayout(null);
    
        JPanel BrewHubPanel = new JPanel( );
        BrewHubPanel.setLayout(null);
        BrewHubPanel.setBackground(Color.ORANGE);
        BrewHubPanel.setBounds(20, 20, 445 , 420);

        JLabel BrewHubMenu = new JLabel("BrewHub Coffee!");
        BrewHubMenu.setFont(new Font ("Bookman Old Style",Font.BOLD, 20));
        BrewHubMenu.setForeground(Color.BLACK);
        BrewHubMenu.setBounds( 170,-97,350,270);

        JLabel label1 = new JLabel ("Select Coffee:");
        label1.setFont (new Font ("Verdana",Font.BOLD, 15));
        label1.setBounds(100,-58, 200, 250);
        label1.setForeground(Color.black);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityLabel.setForeground(Color.BLACK);
        quantityLabel.setFont(new Font ("Verdana", Font.BOLD, 15));
        quantityLabel.setBounds(300,55, 120, 25);
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
String[] items =  {"Latte - ", "Cappucino -", "Americano - ", "Spanish latte - "};
int[] prices = {10,12,11,15};

JCheckBox latte = new JCheckBox(items[0] + " $" + prices[0] + ".00");
latte.setBounds(100, 85, 150, 20);
latte.setFont(new Font ("Tahoma",Font.BOLD, 13));
latte.setBackground(Color.ORANGE);
latte.setFocusable(false);


JCheckBox cappu= new JCheckBox(items[1] + "$" + prices[1] + ".00");
cappu.setFont(new Font("Tahoma", Font.BOLD,13));
cappu.setBounds(100, 115, 150, 20);
cappu.setBackground(Color.ORANGE);
cappu.setFocusable(false);


JCheckBox americano = new JCheckBox(items[2] + "$" + prices[2] + ".00");
americano.setFont (new Font("Tahoma",Font.BOLD,13));
americano.setBounds(100, 145, 180, 20);
americano.setBackground(Color.ORANGE);
americano.setFocusable(false);

JCheckBox sp = new JCheckBox(items[3] + "$" + prices[3] + ".00");
sp.setFont(new Font ("Tahoma", Font.BOLD, 13));
sp.setBounds(100, 175, 180, 20); 
sp.setBackground(Color.ORANGE);
sp.setFocusable(false);


JTextField tflatte = new JTextField("0");
tflatte.setBounds(280, 85, 100, 20);
JTextField tfcappu = new JTextField("0");
tfcappu.setBounds(280, 115, 100, 20);
JTextField tfamericano = new JTextField("0");
tfamericano.setBounds(280, 145, 100, 20);
JTextField tfsp = new JTextField("0");
tfsp.setBounds(280, 175, 100, 20);

JLabel amount = new JLabel("Total Amount: $0.00");
amount.setBounds(180, 210, 180, 20);

//////////btton for ccalculation 
JButton Button = new JButton("Calculate Total");
 Button.setFocusable(false);
 Button.setFont( new Font("Verdana", Font.BOLD,15));
 Button.setBounds(110, 240, 260, 30);

 
/////////////////////////////////////////////////////////////
int [] total = {0};

Button.addActionListener(e -> {
    handleCheckbox(latte, tflatte, prices[0], total, amount);
    handleCheckbox(cappu, tfcappu, prices[1], total, amount);
    handleCheckbox(americano, tfamericano, prices[2], total, amount);
    handleCheckbox(sp, tfsp, prices[3], total, amount);
});

// undo button /////

        JButton undo = new JButton("Undo");
        undo.setFocusable(false);
        undo.setFont(new Font("Verdana",Font.BOLD,15));
        undo.setBounds(110, 280, 260, 30);
      
        undo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (undo.isSelected()){
                }
                cappu.setSelected(false);
                latte.setSelected(false);
                americano.setSelected(false);
                sp.setSelected(false);
                amount.setText("Total Amount: $0.00");
                tflatte.setText("0");
                tfcappu.setText("0");
                tfamericano.setText("0");
                tfsp.setText("0");

            
            }
    
        });

                ////Confirm button///////
        JButton cnf  = new JButton("Confirm");
        cnf.setFocusable(false);
        cnf.setFont(new Font("Verdana",Font.BOLD,15));
        cnf.setBounds(110,320, 260, 30);
    
        cnf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                int amounts =  JOptionPane.showConfirmDialog(BrewHubFrame, amount, "Confirm Total", JOptionPane.YES_NO_OPTION);
                if (amounts == JOptionPane.NO_OPTION){
                        return;
                }if(amounts == JOptionPane.YES_OPTION){
                    openDashboard();
                    BrewHubFrame.dispose();
               
                }
            }
                   
                });
        
            
        JButton cancel =  new JButton("Cancel");
        cancel.setFocusable(false);
        cancel.setFont(new Font("Verdaba",Font.BOLD,15));
        cancel.setBounds(110,360,260,30);

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                BrewHubFrame.dispose();

            }
        });
        BrewHubFrame.add(latte); 
        BrewHubFrame.add(cappu); 
        BrewHubFrame.add(americano); 
        BrewHubFrame.add(sp); 
        BrewHubFrame.add(tflatte);
        BrewHubFrame.add(tfcappu);
        BrewHubFrame.add(tfamericano);
        BrewHubFrame.add(tfsp);
        BrewHubFrame.add(quantityLabel);
        BrewHubFrame.add(amount);
        BrewHubFrame.add(Button);        
        BrewHubFrame.add(cancel);
        BrewHubFrame.add(undo);
        BrewHubFrame.add(cnf);
        BrewHubFrame.add(label1);
        BrewHubFrame.add(BrewHubMenu);
        BrewHubFrame.add(BrewHubPanel);
        BrewHubFrame.setVisible(true);

    }

       public static void handleCheckbox(JCheckBox item, JTextField Quantity, int price, int[] total, JLabel totalLabel) {
           try {
               int value = Integer.parseInt(Quantity.getText());
               int amount = value * price;
    
                if (item.isSelected()) {
                    total[0] += amount;
                }
    
                totalLabel.setText("Total Amount: $" + total[0] +".00");
             } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Enter valid Quantity" + item.getText());
                item.setSelected(false);
           }
        }

    public static void openDashboard(){
        JFrame finalFrame = new JFrame("Order Conformation");
        finalFrame.setSize(750, 300);
        finalFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
    
        JLabel information1 = new JLabel(" Ordered Confirmed! ");
        information1.setBounds(5, 150, 50, 15);
        information1.setForeground(Color.BLACK);
        information1.setFont(new Font("Verdana", Font.BOLD,15));

        JLabel information2 = new JLabel(" Thank you for Purchasing! ");
        information2.setFont(new Font("Verdana", Font.BOLD,15));
        information2.setForeground(Color.BLACK);
        information2.setBounds(5, 150, 50, 15);
        information2.setHorizontalAlignment(SwingConstants.CENTER);

        finalFrame.add(information2);
        finalFrame.setLocationRelativeTo(null);
        finalFrame.add(information1);
        finalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finalFrame.setVisible(true);
    
    
    }   
}