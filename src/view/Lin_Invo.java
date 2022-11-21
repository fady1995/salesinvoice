package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author EL-Romany
 */
public class Lin_Invo extends JDialog{
    private JTextField itemNamfi;
    private JTextField itemCoufi;
    private JTextField itemPricfi;
    private JLabel itemNamlab;
    private JLabel itemCoulab;
    private JLabel itemPriclab;
    private JButton saveButt;
    private JButton cancelButt;
    
    public Lin_Invo(Frameinvoicegen frameInvo) {
        itemNamfi = new JTextField(15);
        itemNamlab = new JLabel("    Item Name");
        
        itemCoufi = new JTextField(15);
        itemCoulab = new JLabel("    Item Count");
        
        itemPricfi = new JTextField(15);
        itemPriclab = new JLabel("    Item Price");
        
        saveButt = new JButton("Save Itmes");
        cancelButt = new JButton("Cancel");
        
        saveButt.setActionCommand("creaLin");
        cancelButt.setActionCommand("creaLinCan");
        
        saveButt.addActionListener(frameInvo.getController());
        cancelButt.addActionListener(frameInvo.getController());
        setLayout(new GridLayout(4, 2));
        
        add(itemNamlab);
        add(itemNamfi);
        add(itemCoulab);
        add(itemCoufi);
        add(itemPriclab);
        add(itemPricfi);
        add(saveButt);
        add(cancelButt);
        
        pack();
    }

    public JTextField getitemNamfi() {
        return itemNamfi;
    }

    public JTextField getitemCoufi() {
        return itemCoufi;
    }

    public JTextField getitemPricfi() {
        return itemPricfi;
    }
}
