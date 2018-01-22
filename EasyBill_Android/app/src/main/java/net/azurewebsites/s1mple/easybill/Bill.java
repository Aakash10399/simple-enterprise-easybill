package net.azurewebsites.s1mple.easybill;

public class Bill {
    public String GSTIN;
    public String products;
    public String price;
    public String quantity;
    public String cgst;
    public String sgst;
    public String mobile;
    public Bill( String GSTIN, String products, String price, String quantity, String cgst, String sgst, String mobile) {
        this.GSTIN = GSTIN;
        this.products = products;
        this.price = price;
        this.quantity = quantity;
        this.cgst = cgst;
        this.sgst = sgst;
        this.mobile = mobile;
    }
    public String getGSTIN() {
        return GSTIN;
    }

    public void setGSTIN(String GSTIN) {
        this.GSTIN = GSTIN;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCgst() {
        return cgst;
    }

    public void setCgst(String cgst) {
        this.cgst = cgst;
    }

    public String getSgst() {
        return sgst;
    }

    public void setSgst(String sgst) {
        this.sgst = sgst;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
