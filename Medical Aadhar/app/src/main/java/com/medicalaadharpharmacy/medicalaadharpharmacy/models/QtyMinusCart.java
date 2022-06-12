package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

public class QtyMinusCart {

    String product_id;
    String qty;
    String price;
    String name;
    String img;
    String shiping_cost;
    String schedule;
    String discounted_percentage;
    String mrp;

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getShiping_cost() {
        return shiping_cost;
    }

    public void setShiping_cost(String shiping_cost) {
        this.shiping_cost = shiping_cost;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDiscounted_percentage() {
        return discounted_percentage;
    }

    public void setDiscounted_percentage(String discounted_percentage) {
        this.discounted_percentage = discounted_percentage;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }
}
