package com.medicalaadharpharmacy.medicalaadharpharmacy.models;

public class Customer {

    String customer_id;
    String email;
    String full_name;
    String mobile_number;
    String credential;
    String is_active;
    String is_deleted;
    String update_flag;
    String created_on;
    String last_updated_on;
    String OTP;
    String OTP_created;
    String profile_images;
    String Username;
    String Password;
    String my_referral;

    public String getMy_referral() {
        return my_referral;
    }

    public void setMy_referral(String my_referral) {
        this.my_referral = my_referral;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getCredential() {
        return credential;
    }

    public void setCredential(String credential) {
        this.credential = credential;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(String is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getUpdate_flag() {
        return update_flag;
    }

    public void setUpdate_flag(String update_flag) {
        this.update_flag = update_flag;
    }

    public String getCreated_on() {
        return created_on;
    }

    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getLast_updated_on() {
        return last_updated_on;
    }

    public void setLast_updated_on(String last_updated_on) {
        this.last_updated_on = last_updated_on;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public String getOTP_created() {
        return OTP_created;
    }

    public void setOTP_created(String OTP_created) {
        this.OTP_created = OTP_created;
    }

    public String getProfile_images() {
        return profile_images;
    }

    public void setProfile_images(String profile_images) {
        this.profile_images = profile_images;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
