package controller;

import model.InvoiceHea;
import model.Invo_Hea_Tab;
import model.InvoiceLin;
import model.Invo_Lin_Tab;
import view.Hea_Invo;
import view.Frameinvoicegen;
import view.Lin_Invo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Command_pro implements ActionListener, ListSelectionListener {

    private Frameinvoicegen frameInvo;
    private Hea_Invo invoHea;
    private Lin_Invo invoLine;

    public Command_pro(Frameinvoicegen frameInvo) {
        this.frameInvo = frameInvo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println("in run: " + actionCommand);
        switch (actionCommand) {
             //  all News
            case "Crea New Invo":
                CreaNewInvo();
                break;
            case "Crea New Itm":
                CreaNewItm();
                break;         
                // all create
            case "creaLin":
                CreaLinsav();
                break;
            case "creaLinCan":
                CancreaLin();
                break;
                // all Delete
            case "Del Invo":
                delInvo();
                break;
            case "Del Itm":
                delItm();
                break;
                // all Cancel
            case "creaInvoCan":
                CancreaInvo();
                break;
            case "creaInvo":
                CreaInvosav();
                break;
                // Load and Save
            case "Load File":
                loadFile();
                break;
            case "Save File":
                saveFile();
                break;
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedIndex = frameInvo.getInvoiceTable().getSelectedRow();
        if (selectedIndex != -1) {
            InvoiceHea currentInvoice = frameInvo.getInvoices().get(selectedIndex);
            frameInvo.getInvoiceNumLabel().setText("" + currentInvoice.getinvoNum());
            frameInvo.getInvoiceDateLabel().setText(currentInvoice.getinvoDate());
            frameInvo.getCustomerNameLabel().setText(currentInvoice.getcusName());
            frameInvo.getInvoiceTotalLabel().setText("" + currentInvoice.getInvoiceTotal());
            Invo_Lin_Tab linTabMod = new Invo_Lin_Tab(currentInvoice.getinvoLin());
            frameInvo.getLineTable().setModel(linTabMod);
            linTabMod.fireTableDataChanged();
        }
    }

    private void loadFile() {
        JOptionPane.showMessageDialog(frameInvo, "please chose header file first then chose the line file", "attention", JOptionPane.INFORMATION_MESSAGE);
        JFileChooser fc = new JFileChooser();
        try {
            int result = fc.showOpenDialog(frameInvo);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                Path headerPath = Paths.get(headerFile.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(headerPath);
                System.out.println("Invoices have been read");
                ArrayList<InvoiceHea> invoicesArray = new ArrayList<>();
                for (String headerLine : headerLines) {
                    try {
                        String[] headerParts = headerLine.split(",");
                        int invoiceNum = Integer.parseInt(headerParts[0]);
                        String invoiceDate = headerParts[1];
                        String customerName = headerParts[2];

                        InvoiceHea invoice = new InvoiceHea(invoiceNum, invoiceDate, customerName);
                        invoicesArray.add(invoice);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(frameInvo, "Error in line format", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                result = fc.showOpenDialog(frameInvo);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fc.getSelectedFile();
                    Path linePath = Paths.get(lineFile.getAbsolutePath());
                    List<String> lineLines = Files.readAllLines(linePath);
                    for (String lineLine : lineLines) {
                        try {
                            String lineParts[] = lineLine.split(",");
                            int invoiceNum = Integer.parseInt(lineParts[0]);
                            String itemName = lineParts[1];
                            double itemPrice = Double.parseDouble(lineParts[2]);
                            int itemCou = Integer.parseInt(lineParts[3]);
                            InvoiceHea invo = null;
                            for (InvoiceHea invoice : invoicesArray) {
                                if (invoice.getinvoNum() == invoiceNum) {
                                    invo = invoice;
                                    break;
                                }
                            }

                            InvoiceLin line = new InvoiceLin(itemName, itemPrice, itemCou, invo);
                            invo.getinvoLin().add(line);
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(frameInvo, "Error in Invoice Line format", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                frameInvo.setInvoices(invoicesArray);
                Invo_Hea_Tab invoicesTableModel = new Invo_Hea_Tab(invoicesArray);
                frameInvo.setInvoicesTableModel(invoicesTableModel);
                frameInvo.getInvoiceTable().setModel(invoicesTableModel);
                frameInvo.getInvoicesTableModel().fireTableDataChanged();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frameInvo, "Folder/File path is not found", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveFile() {
        JOptionPane.showMessageDialog(frameInvo, "please save the header file first then save the line file", "attention", JOptionPane.INFORMATION_MESSAGE);
        ArrayList<InvoiceHea> invoices = frameInvo.getInvoices();
        String headers = "";
        String invoLin = "";
        for (InvoiceHea invoice : invoices) {
            String invCSV = invoice.getAsCSV();
            headers += invCSV;
            headers += "\n";

            for (InvoiceLin line : invoice.getinvoLin()) {
                String lineCSV = line.getAsCSV();
                invoLin += lineCSV;
                invoLin += "\n";
            }
        }
        try {
            JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(frameInvo);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                hfw.write(headers);
                hfw.flush();
                hfw.close();
                result = fc.showSaveDialog(frameInvo);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fc.getSelectedFile();
                    FileWriter lfw = new FileWriter(lineFile);
                    lfw.write(invoLin);
                    lfw.flush();
                    lfw.close();
                }
            }
        } catch (Exception ex) {

        }
    }

    private void delItm() {
        int selectedRow = frameInvo.getLineTable().getSelectedRow();

        if (selectedRow != -1) {
            Invo_Lin_Tab linTabMod = (Invo_Lin_Tab) frameInvo.getLineTable().getModel();
            linTabMod.getinvoLin().remove(selectedRow);
            linTabMod.fireTableDataChanged();
            frameInvo.getInvoicesTableModel().fireTableDataChanged();
        }
    }

    private void delInvo() {
        int selectedRow = frameInvo.getInvoiceTable().getSelectedRow();
        if (selectedRow != -1) {
            frameInvo.getInvoices().remove(selectedRow);
            frameInvo.getInvoicesTableModel().fireTableDataChanged();
        }
    }
    
    private void CreaInvosav() {
        String invoDate = invoHea.getinvDatefi().getText();
        String cusName = invoHea.getcusNamfi().getText();
        int invoNum = frameInvo.getNextInvoiceNum();
        try {
            String[] dateParts = invoDate.split("-"); 
            if (dateParts.length < 3) {
                JOptionPane.showMessageDialog(frameInvo, "Wrong date format, please use this format DD-MM-YYYY", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int year = Integer.parseInt(dateParts[2]);
                int month = Integer.parseInt(dateParts[1]);
                int day = Integer.parseInt(dateParts[0]);


                if (month > 12 || day > 31) {
               
                    JOptionPane.showMessageDialog(frameInvo, "Wrong date format, please enter correct date and use this format DD-MM-YYYY", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    InvoiceHea invoice = new InvoiceHea(invoNum, invoDate, cusName);
                    frameInvo.getInvoices().add(invoice);
                    frameInvo.getInvoicesTableModel().fireTableDataChanged();
                    invoHea.setVisible(false);
                    invoHea.dispose();
                    invoHea = null;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frameInvo, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void CreaLinsav() {
        String itemNam = invoLine.getitemNamfi().getText();
        String countStr = invoLine.getitemCoufi().getText();
        String priceStr = invoLine.getitemPricfi().getText();
        int itemCou = Integer.parseInt(countStr);
        double itemPri = Double.parseDouble(priceStr);
        int selectedInvoice = frameInvo.getInvoiceTable().getSelectedRow();
        if (selectedInvoice != -1) {
            InvoiceHea invoice = frameInvo.getInvoices().get(selectedInvoice);
            InvoiceLin line = new InvoiceLin(itemNam, itemPri, itemCou, invoice);
            invoice.getinvoLin().add(line);
            Invo_Lin_Tab linTabMod = (Invo_Lin_Tab) frameInvo.getLineTable().getModel();
            linTabMod.fireTableDataChanged();
            frameInvo.getInvoicesTableModel().fireTableDataChanged();
        }
        invoLine.setVisible(false);
        invoLine.dispose();
        invoLine = null;
    }
    
    private void CancreaLin() {
        invoLine.setVisible(false);
        invoLine.dispose();
        invoLine = null;
    }
    
    private void CancreaInvo() {
        invoHea.setVisible(false);
        invoHea.dispose();
        invoHea = null;
    }
    
    private void CreaNewInvo() {
        invoHea = new Hea_Invo(frameInvo);
        invoHea.setVisible(true);
    }
    
    private void CreaNewItm() {
        invoLine = new Lin_Invo(frameInvo);
        invoLine.setVisible(true);
    }   
}