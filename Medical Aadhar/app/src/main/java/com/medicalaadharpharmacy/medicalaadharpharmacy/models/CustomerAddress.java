package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

public class CustomerAddress {

    String c_addresses_id;
    String addresses;
    String customer_id;
    String pincode;
    String city;
    String state;
    String country;
    String land_mark;
    String is_default;
    String house_no;
    String lag;
    String lat;

    public String getLag() {
        return lag;
    }

    public void setLag(String lag) {
        this.lag = lag;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getHno() {
        return house_no;
    }

    public void setHno(String house_no) {
        this.house_no = house_no;
    }

    public String getC_addresses_id() {
        return c_addresses_id;
    }

    public void setC_addresses_id(String c_addresses_id) {
        this.c_addresses_id = c_addresses_id;
    }

    public String getAddresses() {
        return addresses;
    }

    public void setAddresses(String addresses) {
        this.addresses = addresses;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLand_mark() {
        return land_mark;
    }

    public void setLand_mark(String land_mark) {
        this.land_mark = land_mark;
    }

    public String getIs_default() {
        return is_default;
    }

    public void setIs_default(String is_default) {
        this.is_default = is_default;
    }
}
