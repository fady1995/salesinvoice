
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Invo_Hea_Tab extends AbstractTableModel {
    private ArrayList<InvoiceHea> invoices;
    private String[] invoColum = {"NO.", "Date", "Customer", "Total"};
    
    public Invo_Hea_Tab(ArrayList<InvoiceHea> invoices) {
        this.invoices = invoices;
    }
    
    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        return invoColum.length;
    }

    @Override
    public String getColumnName(int column) {
        return invoColum[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columInd) {
        InvoiceHea invoice = invoices.get(rowIndex);
        
        switch (columInd) {
            case 0: return invoice.getinvoNum();
            case 1: return invoice.getinvoDate();
            case 2: return invoice.getcusName();
            case 3: return invoice.getInvoiceTotal();
            default : return "";
        }
    }
}
