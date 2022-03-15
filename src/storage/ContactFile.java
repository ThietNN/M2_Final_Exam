package storage;

import model.Contact;

import java.io.*;
import java.util.ArrayList;

public class ContactFile {
    public ArrayList<Contact> readFile(String filePath) {
        File file = new File(filePath);
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            ArrayList<Contact> contactList = (ArrayList<Contact>) result;
            ois.close();
            fis.close();
            return contactList;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static void writeFile(ArrayList<Contact> contactList) {
        try {
            FileOutputStream fos = new FileOutputStream("contact_list.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(contactList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}