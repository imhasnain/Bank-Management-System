package bms;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Functions f = new Functions();
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Select a System:");
            System.out.println("Enter 1 for Queue System");
            System.out.println("Enter 2 for Account Management");
            System.out.println("Enter 0 to Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    queueMenu(f);
                    break;
                case 2:
                	accountMenu(f);
                    break;
                case 0:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void queueMenu(Functions f) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Queue System Menu:");
            System.out.println("Enter 1 to Insert");
            System.out.println("Enter 2 to Display");
            System.out.println("Enter 3 to Dequeue");
            System.out.println("Enter 0 to Return to Main Menu");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    f.enqueue();
                    break;
                case 2:
                    f.display();
                    break;
                case 3:
                    f.dequeue();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }

    private static void accountMenu(Functions f) {
        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Account Management Menu:");
            System.out.println("Enter 1 to Create Account");
            System.out.println("Enter 2 to View Account");
            System.out.println("Enter 3 to Deposit");
            System.out.println("Enter 4 to Withdraw");
            System.out.println("Enter 0 to Return to Main Menu");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    f.createAccount();
                    break;
                case 2:
                    System.out.println("Enter Account Number: ");
                    int accno = sc.nextInt();
                    f.viewAccount(accno);
                    break;
                case 3:
                    System.out.println("Enter Account Number: ");
                    accno = sc.nextInt();
                    System.out.println("Enter Amount to Deposit: ");
                    double depositAm = sc.nextDouble();
                    f.deposit(accno, depositAm);
                    break;
                case 4:
                    System.out.println("Enter Account Number: ");
                    accno = sc.nextInt();
                    System.out.println("Enter Amount to Withdraw: ");
                    double withdrawam = sc.nextDouble();
                    f.withdraw(accno, withdrawam);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }
        }
    }
}
