package com.user;
public class User {
private String fname,lname,email,gender,country,err;

    public User() {
        fname="";
        lname="";
        email="";
        gender="";
        country="";
        
    }

    public User(String fname, String lname, String email, String gender, String country) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.gender = gender;
        this.country = country;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getErr() {
        return err;
    }

    public void setErr(String err) {
        this.err = err;
    }


}
