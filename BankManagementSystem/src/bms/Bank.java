package bms;

public class Bank {
    String name;
    int age;
    char gender;
    int id;
    int accno;
    double balance;
    static int nextId = 1;
    static int nextAcc = 1000;

    public Bank() {
        this.id = nextId++;
        this.accno = nextAcc++;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount");
            return;
        }
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }
}
