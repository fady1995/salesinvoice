
package model;

import java.util.ArrayList;

public class InvoiceHea {
    private int invoNum;
    private String invoDate;
    private String cusName;
    private ArrayList<InvoiceLin> invoLin;
    
    public String getAsCSV() {
        return invoNum + "," + invoDate + "," + cusName;
    }
    
    public String getinvoDate() {
        return invoDate;
    }

    public void setinvoDate(String invoDate) {
        this.invoDate = invoDate;
    }
    
    public int getinvoNum() {
        return invoNum;
    }

    public void setinvoNum(int invoNum) {
        this.invoNum = invoNum;
    }
    
    public InvoiceHea() {
    }

    public InvoiceHea(int invoNum, String invoDate, String cusName) {
        this.invoNum = invoNum;
        this.invoDate = invoDate;
        this.cusName = cusName;
    }

    public double getInvoiceTotal() {
        double total = 0.0;
        for (InvoiceLin line : getinvoLin()) {
            total += line.getLinTotal();
        }
        return total;
    }
    
    public ArrayList<InvoiceLin> getinvoLin() {
        if (invoLin == null) {
            invoLin = new ArrayList<>();
        }
        return invoLin;
    }

    public String getcusName() {
        return cusName;
    }

    public void setcusName(String cusName) {
        this.cusName = cusName;
    }

    @Override
    public String toString() {
        return "Invoice{" + "number=" + invoNum + ", date=" + invoDate + ", customer=" + cusName + '}';
    }
       
}

