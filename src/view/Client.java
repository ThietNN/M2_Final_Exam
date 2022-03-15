package view;

import controller.ContactManager;
import model.Contact;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        ArrayList<Contact> contactArrayList = contactManager.contactFile.readFile("contact_list.txt");

        Contact contact1 = new Contact("123","1","Thiet","male","390NS","123@gmail.com","122");
        Contact contact2 = new Contact("456","2","Nguyen","female","093SN","456@hotmail.com","598");
        contactArrayList.add(contact1);
        contactArrayList.add(contact2);
        contactManager.writeFile();

        Scanner scanner = new Scanner(System.in);
        int choice;
        contactManager.showMenu();
        do {
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    contactManager.showContactList();
                    break;
                case 2:
                    contactManager.createNewContact();
                    break;
                case 3:
                    contactManager.editContact();
                    break;
                case 4:
                    contactManager.removeContact();
                    break;
                case 5:
                    contactManager.searchContact();
                    break;
                case 6:
                    contactManager.readFile();
                    break;
                case 7:
                    contactManager.writeFile();
                    break;
            }

        }while (choice !=0);

    }
}
