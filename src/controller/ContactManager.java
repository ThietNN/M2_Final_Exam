package controller;

import controller.checkvalidate.CheckMail;
import controller.checkvalidate.CheckValidate;
import model.Contact;
import storage.ContactFile;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    public ContactFile contactFile = new ContactFile();
    public ArrayList<Contact> contactArrayList = contactFile.readFile("contact_list.txt");

    public ArrayList<Contact> getFile(){
        return contactArrayList;
    }

    public void showMenu(){
        System.out.println(" --- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ --- ");
        System.out.println("Chọn chức năng theo số để tiếp tục: ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi từ file");
    }
    public void showContactList(){
        System.out.println("Press enter to continue");
        for (int i = 0; contactArrayList.get(i) != null; i++){
            if (enterToContinue())
                System.out.println(contactArrayList.get(i));
            else
                break;
        }
    }
    public boolean enterToContinue(){
        Scanner scanner = new Scanner(System.in);
        String check = scanner.nextLine();
        return check.equals("");
    }

    public void createNewContact(){
        CheckValidate checkValidate = new CheckValidate();
        String phoneNumber = checkValidate.checkPhoneNumber();
        boolean checkExistence = checkExistenceByPhoneNumber(phoneNumber);
        if (checkExistence){
            System.err.println("This phone number is already exist");
            return;
        }
        Contact contact = new Contact();
        contact.setPhoneNumber(phoneNumber);
        setGroup(contact);
        setName(contact);
        setGender(contact);
        setAddress(contact);
        setMail(contact);
        contactArrayList.add(contact);
        System.out.println("New contact added successfully");
    }

    public void setPhoneNumber(Contact contact){
        CheckValidate checkValidate = new CheckValidate();
        String phoneNumber = checkValidate.checkPhoneNumber();
        contact.setPhoneNumber(phoneNumber);
    }
    public void setGroup(Contact contact){
        CheckValidate checkValidate = new CheckValidate();
        String group = checkValidate.checkGroup();
        contact.setGroup(group);
    }
    public void setName(Contact contact){
        CheckValidate checkValidate = new CheckValidate();
        String name = checkValidate.checkName();
        contact.setName(name);
    }
    public void setGender(Contact contact){
        CheckValidate checkValidate = new CheckValidate();
        String gender = checkValidate.checkGender();
        contact.setGender(gender);
    }
    public void setAddress(Contact contact){
        CheckValidate checkValidate = new CheckValidate();
        String address = checkValidate.checkAddress();
        contact.setAddress(address);
    }
    public void setDOB(Contact contact){
        CheckValidate checkValidate = new CheckValidate();
        String dob = checkValidate.checkDOB();
        contact.setDob(dob);
    }

    public void setMail(Contact contact){
        CheckMail checkMail = new CheckMail();
        CheckValidate checkValidate = new CheckValidate();
        while(true) {
            String mail = checkValidate.checkMail();
            boolean validate = checkMail.validate(mail);
            if (validate) {
                contact.setMail(mail);
                break;
            }
            else{
                System.out.println("Invalid mail format");
            }
        }
    }
    public void editContact(){
        CheckValidate checkValidate = new CheckValidate();
        Scanner scanner = new Scanner(System.in);
        String phoneNumber = checkValidate.checkPhoneNumber();
        boolean checkExistence = checkExistenceByPhoneNumber(phoneNumber);
        if (checkExistence){
            System.out.println("Phone number found. Proceed to edit");
        }else{
            System.err.println("Phone number not found");
            return;
        }
        int position = getContactPosition(phoneNumber);
        Contact contact = getContactByPhoneNumber(phoneNumber);
        editMenu();
        int choice;
        do {
             choice = scanner.nextInt();
             switch (choice){
                 case 1:
                     setGroup(contact);
                     break;
                 case 2:
                     setName(contact);
                     break;
                 case 3:
                     setGender(contact);
                     break;
                 case 4:
                     setAddress(contact);
                     break;
                 case 5:
                     setDOB(contact);
                     break;
                 case 6:
                     setMail(contact);
                     break;
             }
        }while (choice !=0);
        contactArrayList.set(position,contact);
        System.out.println("Contact edited successfully");
    }
    public void editMenu(){
        System.out.println("Edit menu:");
        System.out.println("1. Group");
        System.out.println("2. Name");
        System.out.println("3. Gender");
        System.out.println("4. Address");
        System.out.println("5. Birthday");
        System.out.println("6. Mail");
        System.out.println("0. Exit");
    }

    public void removeContact(){
        Scanner scanner = new Scanner(System.in);
        CheckValidate checkValidate = new CheckValidate();
        boolean checkExistence;
        do {
            String phoneNumber = checkValidate.checkPhoneNumber();
            checkExistence = checkExistenceByPhoneNumber(phoneNumber);
            int position = getContactPosition(phoneNumber);
            if (!checkExistence) {
                System.err.println("This phone number doesn't exist");
            }
            else{
                System.out.println("Phone number found. Enter Y to remove this phone number.");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    contactArrayList.remove(position);
                }else{
                    return;
                }
            }
        }while (!checkExistence);
    }
    public void searchContact(){
        Scanner scanner = new Scanner(System.in);
        int choice;
        searchMenu();
        do {
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> searchByPhoneNumber();
                case 2 -> searchByName();
            }
        }while (choice!=0);
    }

    public void searchByPhoneNumber(){
        CheckValidate checkValidate = new CheckValidate();
        String phoneNumber = checkValidate.checkPhoneNumber();
        boolean existPhone = checkExistenceByPhoneNumber(phoneNumber);
        if (existPhone){
            Contact contact = getContactByPhoneNumber(phoneNumber);
            System.out.println("Contact found: ");
            System.out.println(contact);
        }else{
            System.err.println("Contact not found");
        }
    }
    public void searchByName(){
        CheckValidate checkValidate = new CheckValidate();
        String name = checkValidate.checkName();
        boolean existName = checkExistenceByName(name);
        if (existName){
            Contact contact = getContactByName(name);
            System.out.println("Contact found: ");
            System.out.println(contact);
        }else {
            System.err.println("Contact not found");
        }
    }

    public void searchMenu(){
        System.out.println("Search menu: ");
        System.out.println("1. Search by phone number");
        System.out.println("2. Search by name");
        System.out.println("0. Exit");
    }

    public int getContactPosition(String phoneNumber){
        for (int i =0; i <contactArrayList.size(); i++){
            if (contactArrayList.get(i).getPhoneNumber().equals(phoneNumber))
                return i;
        }
        return -1;
    }

    public Contact getContactByPhoneNumber(String phoneNumber){
        for (Contact contact : contactArrayList){
            if (contact.getPhoneNumber().equals(phoneNumber))
                return contact;
        }
        return null;
    }
    public Contact getContactByName(String name){
        for (Contact contact : contactArrayList){
            if (contact.getName().equals(name))
                return contact;
        }
        return null;
    }

    public boolean checkExistenceByPhoneNumber(String phoneNumber){
        for (Contact contact : contactArrayList){
            if (contact.getPhoneNumber().equals(phoneNumber))
                return true;
            break;
        }
        return false;
    }

    public boolean checkExistenceByName(String name){
        for (Contact contact : contactArrayList){
            if (contact.getName().equals(name))
                return true;
            break;
        }
        return false;
    }

    public void readFile(){
        CheckValidate checkValidate = new CheckValidate();
        String filePath = checkValidate.checkFilePath();
        contactArrayList = contactFile.readFile(filePath);
        System.out.println("File loaded successfully");
    }

    public void writeFile(){
        ContactFile.writeFile(contactArrayList);
        System.out.println("File written successfully");
    }
}
