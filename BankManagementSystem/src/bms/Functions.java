package bms;

import java.util.Scanner;

public class Functions {
    Bank[] b = new Bank[10];
    int c = 0, d = 0, f = 0;
    Scanner s = new Scanner(System.in);

    Node head;

    Functions() {
        for (int i = 0; i < 10; i++) {
            b[i] = new Bank();
        }
    }

    // Queue System Methods
    public void enqueue() {
        if (c == d && f == 1) {
            System.out.println("Queue is Full\n");
        } else {
            System.out.println("Enter Name: ");
            b[c].name = s.next();
            System.out.println("Enter Age: ");
            b[c].age = s.nextInt();
            System.out.println("Enter Gender: ");
            b[c].gender = s.next().charAt(0);
            System.out.println("Assigned id successfully!");
            c++;
            if (c == 10) {
                c = 0;
                f = 1;
            }
        }
    }

    public void dequeue() {
        if (c == d && f == 0) {
            System.out.println("Nothing in queue\n");
        } else {
            int delIndex = d;

            for (int i = 0; i < 10; i++) {
                int currentIndex = (d + i) % 10;
                if (b[currentIndex].age >= 60) {
                    delIndex = currentIndex;
                    break;
                }
            }

            if (b[delIndex].age < 60) {
                for (int i = 0; i < 10; i++) {
                    int currentIndex = (d + i) % 10;
                    if (b[currentIndex].gender == 'F' || b[currentIndex].gender == 'f') {
                        delIndex = currentIndex;
                        break;
                    }
                }
            }

            if (b[delIndex].age < 60 && (b[delIndex].gender != 'F' && b[delIndex].gender != 'f')) {
                for (int i = 0; i < 10; i++) {
                    int currentIndex = (d + i) % 10;
                    if (b[currentIndex].id < b[delIndex].id) {
                        delIndex = currentIndex;
                    }
                }
            }

            System.out.println("Dequeued: " + b[delIndex].id + "\t" + b[delIndex].name + "\t" + b[delIndex].age
                    + "\t" + b[delIndex].gender);

            for (int i = delIndex; i != c; i = (i + 1) % 10) {
                int nextIndex = (i + 1) % 10;
                b[i] = b[nextIndex];
            }
            c = (c - 1 + 10) % 10;
            if (c == d) {
                f = 0;
            }
        }
    }

    public void display() {
        if (c == d && f == 0) {
            System.out.println("Nothing in queue\n");
        } else {
            if (f == 0) {
                for (int i = d; i < c; i++) {
                    System.out.println(b[i].id + "\t" + b[i].name + "\t" + b[i].age + "\t" + b[i].gender);
                }
            } else {
                for (int i = d; i < 10; i++) {
                    System.out.println(b[i].id + "\t" + b[i].name + "\t" + b[i].age + "\t" + b[i].gender);
                }
                for (int i = 0; i < c; i++) {
                    System.out.println(b[i].id + "\t" + b[i].name + "\t" + b[i].age + "\t" + b[i].gender);
                }
            }
        }
    }

    // Account Management Methods using Linked List
    public void createAccount() {
        System.out.println("Enter your Name: ");
        String name = s.next();
        System.out.println("Enter your Age: ");
        int age = s.nextInt();
        System.out.println("Enter your Gender: ");
        char gender = s.next().charAt(0);

        Bank b = new Bank();
        b.name = name;
        b.age = age;
        b.gender = gender;

        Node nn = new Node(b);
        if (head == null) {
            head = nn;
        } else {
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = nn;
        }
        System.out.println("Account created successfully!");
        System.out.println("Your Account Number: " + b.accno);
    }

    public void viewAccount(int accountNumber) {
        Node t = head;
        while (t != null) {
            if (t.account.accno == accountNumber) {
                System.out.println("Account Number: " + t.account.accno);
                System.out.println("Name: " + t.account.name);
                System.out.println("Age: " + t.account.age);
                System.out.println("Gender: " + t.account.gender);
                System.out.println("Balance: " + t.account.balance);
                return;
            }
            t = t.next;
        }
        System.out.println("Account not found");
    }

    public void deposit(int accountNumber, double amount) {
        Node t = head;
        while (t != null) {
            if (t.account.accno == accountNumber) {
                t.account.deposit(amount);
                System.out.println("Deposited " + amount + " to account " + accountNumber);
                return;
            }
            t = t.next;
        }
        System.out.println("Account not found");
    }

    public void withdraw(int accnum, double amount) {
        Node t = head;
        while (t != null) {
            if (t.account.accno == accnum) {
                t.account.withdraw(amount);
                System.out.println("Withdrew " + amount + " from account " + accnum);
                return;
            }
            t = t.next;
        }
        System.out.println("Account not found");
    }
}