
package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author El-Romany
 */
public class Hea_Invo extends JDialog {
    private JTextField cusNamfi;
    private JTextField invDatefi;
    private JLabel cusNamlab;
    private JLabel invDatelab;
    private JButton save;
    private JButton saveNonew;

    public Hea_Invo(Frameinvoicegen frameInvo) {
     
        invDatelab = new JLabel("    Invoice Date:");
        invDatefi = new JTextField(15);
        cusNamlab = new JLabel("    New Customer Name:");
        cusNamfi = new JTextField(15);
        save = new JButton("save Customer");
        saveNonew = new JButton("Cancel");
        
        save.setActionCommand("creaInvo");
        saveNonew.setActionCommand("creaInvoCan");
        
        save.addActionListener(frameInvo.getController());
        saveNonew.addActionListener(frameInvo.getController());
        setLayout(new GridLayout(3, 2));
        
        add(invDatelab);
        add(invDatefi);
        add(cusNamlab);
        add(cusNamfi);
        add(save);
        add(saveNonew);

        pack();
        
    }

    public JTextField getcusNamfi() {
        return cusNamfi;
    }

    public JTextField getinvDatefi() {
        return invDatefi;
    }
    
}
