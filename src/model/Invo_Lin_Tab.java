
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Invo_Lin_Tab extends AbstractTableModel {
    
        public Invo_Lin_Tab(ArrayList<InvoiceLin> invoLin) {
        this.invoLin = invoLin;
    }
    
    private ArrayList<InvoiceLin> invoLin;
    private String[] invoColum = {"NO.", "Item Name", "Item Price", "Count", "Item Total"};

    
    public ArrayList<InvoiceLin> getinvoLin() {
        return invoLin;
    }
    
    @Override
    public int getColumnCount() {
        return invoColum.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columInd) {
        InvoiceLin line = invoLin.get(rowIndex);
        
        switch(columInd) {
            case 0: 
                return line.getInvoice().getinvoNum();
            case 1: 
                return line.getitemNam();
            case 2: 
                return line.getitemPri();
            case 3: 
                return line.getitemCou();
            case 4: 
                return line.getLinTotal();
            default : 
                return "";
        }
    }
    
    @Override
    public String getColumnName(int x) {
        return invoColum[x];
    }
    
    @Override
    public int getRowCount() {
        return invoLin.size();
    }
    
    
}
