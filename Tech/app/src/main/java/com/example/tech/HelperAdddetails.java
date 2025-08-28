package com.example.tech;

public class HelperAdddetails {

    String name,fname,mname,gender,addresse,mobile;

    public HelperAdddetails(String name, String fname, String gender, String mname, String addresse, String mobile) {
        this.name = name;
        this.fname = fname;
        this.gender = gender;
        this.mname = mname;
        this.addresse = addresse;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public  HelperAdddetails(){

    }
}
