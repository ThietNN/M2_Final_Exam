package model;

import java.io.Serializable;

public class Contact implements Serializable {
    String phoneNumber;
    String group, name, gender, address, mail, dob;

    public Contact() {
    }

    public Contact(String phoneNumber, String group, String name, String gender, String address, String mail, String dob) {
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.mail = mail;
        this.dob = dob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString(){
        return "Phone number: " + phoneNumber + ", group: " + group + ", name: " + name + ", gender: " + gender + ", address: " + address + ", mail: " + mail + ", DOB: " + dob;
    }
}
