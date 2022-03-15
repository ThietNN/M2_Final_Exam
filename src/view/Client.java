package view;

import controller.ContactManager;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();

        Scanner scanner = new Scanner(System.in);
        int choice;
        contactManager.showMenu();
        do {
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> contactManager.showContactList();
                case 2 -> contactManager.createNewContact();
                case 3 -> contactManager.editContact();
                case 4 -> contactManager.removeContact();
                case 5 -> contactManager.searchContact();
                case 6 -> contactManager.readFile();
                case 7 -> contactManager.writeFile();
            }

        }while (choice !=0);

    }
}
