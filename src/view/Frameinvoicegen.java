/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Command_pro;
import model.InvoiceHea;
import model.Invo_Hea_Tab;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author El-Romany
 */
public class Frameinvoicegen extends javax.swing.JFrame {

    /**
     * Creates new form InvoiceFrame
     */
    public Frameinvoicegen() {
        this.getContentPane().setBackground(Color.white);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoTab = new javax.swing.JTable();
        invoTab.getSelectionModel().addListSelectionListener(controller);
        invoTab.setModel(getInvoicesTableModel());
        creInvoBut = new javax.swing.JButton();
        creInvoBut.addActionListener(controller);
        delInvoBut = new javax.swing.JButton();
        delInvoBut.addActionListener(controller);
        jLabInvoNumber = new javax.swing.JLabel();
        jLabInvoDate = new javax.swing.JLabel();
        jLabCusName = new javax.swing.JLabel();
        jLabInvoTotal = new javax.swing.JLabel();
        customerNameLabel = new javax.swing.JLabel();
        invoiceDateLabel = new javax.swing.JLabel();
        invoiceNumLabel = new javax.swing.JLabel();
        invoiceTotalLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        linTab = new javax.swing.JTable();
        creLinBut = new javax.swing.JButton();
        creLinBut.addActionListener(controller);
        delLinBut = new javax.swing.JButton();
        delLinBut.addActionListener(controller);
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jMnuB1 = new javax.swing.JMenuBar();
        jMnu1 = new javax.swing.JMenu();
        loadFileMnu = new javax.swing.JMenuItem();
        loadFileMnu.addActionListener(controller);
        saveFileMnu = new javax.swing.JMenuItem();
        saveFileMnu.addActionListener(controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setName("rootfram"); // NOI18N

        jScrollPane1.setBackground(this.getContentPane().getBackground());

        invoTab.setBackground(this.getContentPane().getBackground());
        invoTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(invoTab);

        creInvoBut.setBackground(this.getContentPane().getBackground());
        creInvoBut.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        creInvoBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user_add.png"))); // NOI18N
        creInvoBut.setText("Create New Invoice");
        creInvoBut.setToolTipText("");
        creInvoBut.setActionCommand("Crea New Invo");

        delInvoBut.setBackground(this.getContentPane().getBackground());
        delInvoBut.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        delInvoBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/imag1.png"))); // NOI18N
        delInvoBut.setText("Delete Invoice");
        delInvoBut.setActionCommand("Del Invo");

        jLabInvoNumber.setBackground(this.getContentPane().getBackground());
        jLabInvoNumber.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabInvoNumber.setText("Inoice Number");
        jLabInvoNumber.setOpaque(true);

        jLabInvoDate.setBackground(this.getContentPane().getBackground());
        jLabInvoDate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabInvoDate.setText("Invoice Date");
        jLabInvoDate.setOpaque(true);

        jLabCusName.setBackground(this.getContentPane().getBackground());
        jLabCusName.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabCusName.setText("Customer Name");
        jLabCusName.setOpaque(true);

        jLabInvoTotal.setBackground(this.getContentPane().getBackground());
        jLabInvoTotal.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabInvoTotal.setText("Invoice Total");
        jLabInvoTotal.setOpaque(true);

        customerNameLabel.setBackground(this.getContentPane().getBackground());
        customerNameLabel.setOpaque(true);

        invoiceDateLabel.setBackground(this.getContentPane().getBackground());
        invoiceDateLabel.setOpaque(true);

        invoiceNumLabel.setBackground(this.getContentPane().getBackground());
        invoiceNumLabel.setOpaque(true);

        invoiceTotalLabel.setBackground(this.getContentPane().getBackground());
        invoiceTotalLabel.setOpaque(true);

        jScrollPane2.setBackground(this.getContentPane().getBackground());

        linTab.setBackground(this.getContentPane().getBackground());
        linTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(linTab);

        creLinBut.setBackground(this.getContentPane().getBackground());
        creLinBut.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        creLinBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/images.jpg"))); // NOI18N
        creLinBut.setText("Create New Item");
        creLinBut.setActionCommand("Crea New Itm");

        delLinBut.setBackground(this.getContentPane().getBackground());
        delLinBut.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        delLinBut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/red-delete-button-png-5.png"))); // NOI18N
        delLinBut.setText("Delete Item");
        delLinBut.setActionCommand("Del Itm");

        jMnuB1.setName(""); // NOI18N

        jMnu1.setText("File");

        loadFileMnu.setText("Load File");
        jMnu1.add(loadFileMnu);

        saveFileMnu.setText("Save File");
        jMnu1.add(saveFileMnu);

        jMnuB1.add(jMnu1);

        setJMenuBar(jMnuB1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(creInvoBut)
                        .addGap(37, 37, 37)
                        .addComponent(delInvoBut, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(creLinBut, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delLinBut, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabInvoTotal)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(invoiceTotalLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabInvoNumber)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                    .addComponent(invoiceNumLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabInvoDate)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                    .addComponent(invoiceDateLabel))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabCusName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(customerNameLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabInvoNumber)
                            .addComponent(invoiceNumLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabInvoDate)
                            .addComponent(invoiceDateLabel)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabCusName)
                            .addComponent(customerNameLabel)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabInvoTotal)
                            .addComponent(invoiceTotalLabel))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(creInvoBut, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(delInvoBut, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(delLinBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(creLinBut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frameinvoicegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frameinvoicegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frameinvoicegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frameinvoicegen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frameinvoicegen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creInvoBut;
    private javax.swing.JButton creLinBut;
    private javax.swing.JLabel customerNameLabel;
    private javax.swing.JButton delInvoBut;
    private javax.swing.JButton delLinBut;
    private javax.swing.JTable invoTab;
    private javax.swing.JLabel invoiceDateLabel;
    private javax.swing.JLabel invoiceNumLabel;
    private javax.swing.JLabel invoiceTotalLabel;
    private javax.swing.JLabel jLabCusName;
    private javax.swing.JLabel jLabInvoDate;
    private javax.swing.JLabel jLabInvoNumber;
    private javax.swing.JLabel jLabInvoTotal;
    private javax.swing.JMenu jMnu1;
    private javax.swing.JMenuBar jMnuB1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable linTab;
    private javax.swing.JMenuItem loadFileMnu;
    private javax.swing.JMenuItem saveFileMnu;
    // End of variables declaration//GEN-END:variables
    private ArrayList<InvoiceHea> invoices;
    private Command_pro controller = new Command_pro(this);
    private Invo_Hea_Tab invoicesTableModel;

    public ArrayList<InvoiceHea> getInvoices() {
        if (invoices == null) invoices = new ArrayList<>();
        return invoices;
    }

    public void setInvoices(ArrayList<InvoiceHea> invoices) {
        this.invoices = invoices;
    }

    public Invo_Hea_Tab getInvoicesTableModel() {
        if (invoicesTableModel == null) {
            invoicesTableModel = new Invo_Hea_Tab(getInvoices());
        }
        return invoicesTableModel;
    }

    public void setInvoicesTableModel(Invo_Hea_Tab invoicesTableModel) {
        this.invoicesTableModel = invoicesTableModel;
    }

    public JTextField getCustomerNameLabel() {
        return jTextField2;
    }

    public JTextField getInvoiceDateLabel() {
        return jTextField1;
    }

    public JLabel getInvoiceNumLabel() {
        return invoiceNumLabel;
    }

    public JTable getInvoiceTable() {
        return invoTab;
    }

    public JLabel getInvoiceTotalLabel() {
        return invoiceTotalLabel;
    }

    public JTable getLineTable() {
        return linTab;
    }

    public Command_pro getController() {
        return controller;
    }
    
    public int getNextInvoiceNum() {
        int invoNum = 0;
        
        for (InvoiceHea invoice : getInvoices()) {
            if (invoice.getinvoNum() > invoNum) 
                invoNum = invoice.getinvoNum();
        }
        
        return ++invoNum;
    }
    
    
    
}
