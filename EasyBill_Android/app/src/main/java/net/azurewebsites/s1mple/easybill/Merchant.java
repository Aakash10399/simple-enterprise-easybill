package net.azurewebsites.s1mple.easybill;

public class Merchant {
    public int id_merchant;
    public String merchantName;
    public String userid;
    public String pass_merchant;
    public String products;
    public String sgst;
    public String cgst;
    public String price;

    public Merchant(int id_merchant, String merchantName, String userid, String pass_merchant, String products, String sgst, String cgst, String price) {
        this.id_merchant = id_merchant;
        this.merchantName = merchantName;
        this.userid = userid;
        this.pass_merchant = pass_merchant;
        this.products = products;
        this.sgst = sgst;
        this.cgst = cgst;
        this.price = price;
    }

    public int getId_merchant() {
        return id_merchant;
    }

    public void setId_merchant(int id_merchant) {
        this.id_merchant = id_merchant;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPass_merchant() {
        return pass_merchant;
    }

    public void setPass_merchant(String pass_merchant) {
        this.pass_merchant = pass_merchant;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getSgst() {
        return sgst;
    }

    public void setSgst(String sgst) {
        this.sgst = sgst;
    }

    public String getCgst() {
        return cgst;
    }

    public void setCgst(String cgst) {
        this.cgst = cgst;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
