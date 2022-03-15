package controller.checkvalidate;

import java.util.Scanner;

public class CheckValidate {
    public String checkPhoneNumber(){
        Scanner scanner = new Scanner(System.in);
        String check;
        System.out.println("Enter Phone number: ");
        while (true){
            check = scanner.nextLine();
            if (check.equals(""))
                System.err.println("Please don't leave this field empty. ");
            else
                break;
        }
        return check;
    }
    public String checkName(){
        Scanner scanner = new Scanner(System.in);
        String check;
        System.out.println("Enter contacts' name");
        while (true){
            check = scanner.nextLine();
            if (check.equals(""))
                System.err.println("Please don't leave this field empty. ");
            else
                break;
        }
        return check;
    }
    public String checkGroup(){
        Scanner scanner = new Scanner(System.in);
        String check;
        System.out.println("Enter contacts' group: ");
        while (true){
            check = scanner.nextLine();
            if (check.equals(""))
                System.err.println("Please don't leave this field empty. ");
            else
                break;
        }
        return check;
    }
    public String checkGender(){
        Scanner scanner = new Scanner(System.in);
        String check;
        System.out.println("Enter contacts' gender: ");
        label:
        while (true){
            check = scanner.nextLine();
            switch (check) {
                case "":
                    System.err.println("Please don't leave this field empty. ");
                    break;
                case "male":
                case "female":
                    break label;
                default:
                    System.err.println("Gender can either be 'male' or 'female'");
                    break;
            }
        }
        return check;
    }
    public String checkAddress(){
        Scanner scanner = new Scanner(System.in);
        String check;
        System.out.println("Enter contacts' address: ");
        while (true){
            check = scanner.nextLine();
            if (check.equals(""))
                System.err.println("Please don't leave this field empty. ");
            else
                break;
        }
        return check;
    }
    public String checkDOB(){
        Scanner scanner = new Scanner(System.in);
        String check;
        System.out.println("Enter DOB: ");
        while (true){
            check = scanner.nextLine();
            if (check.equals(""))
                System.err.println("Please don't leave this field empty. ");
            else
                break;
        }
        return check;
    }

    public String checkFilePath(){
        Scanner scanner = new Scanner(System.in);
        String check;
        System.out.println("Enter File path: ");
        while (true){
            check = scanner.nextLine();
            if (check.equals(""))
                System.err.println("Please don't leave this field empty. ");
            else
                break;
        }
        return check;
    }
    public String checkMail(){
        Scanner scanner = new Scanner(System.in);
        String check;
        System.out.println("Enter mail: ");
        while (true){
            check = scanner.nextLine();
            if (check.equals(""))
                System.err.println("Please don't leave this field empty. ");
            else
                break;
        }
        return check;
    }

}
