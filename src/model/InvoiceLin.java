
package model;

 public class InvoiceLin {
    private String itemNam;
    private double itemPri;
    private int itemCou;
    private InvoiceHea invoice;
    public InvoiceLin() {
    }

    public InvoiceLin(String itemNam, double itemPri, int itemCou, InvoiceHea invoice) {
        this.itemNam = itemNam;
        this.itemPri = itemPri;
        this.itemCou = itemCou;
        this.invoice = invoice;
    }

    public double getLinTotal() {
        return itemPri * itemCou;
    }
    
    public int getitemCou() {
        return itemCou;
    }

    public void setitemCou(int itemCou) {
        this.itemCou = itemCou;
    }

    public String getitemNam() {
        return itemNam;
    }

    public void setitemNam(String itemNam) {
        this.itemNam = itemNam;
    }

    public double getitemPri() {
        return itemPri;
    }

    public void setitemPri(double itemPri) {
        this.itemPri = itemPri;
    }

    @Override
    public String toString() {
        return "Line{" + "number=" + invoice.getinvoNum() + ", item=" + itemNam + ", price=" + itemPri + ", count=" + itemCou + '}';
    }

    public InvoiceHea getInvoice() {
        return invoice;
    }
    
    public String getAsCSV() {
        return invoice.getinvoNum() + "," + itemNam + "," + itemPri + "," + itemCou;
    }
    
}