package com.example.exercises;

public class BankAccount {
    private double balance;
    private double interestRate;

    public BankAccount(double balance, double interestRate) {
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        balance += amount;
    }
    //pogo,pq,

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
    }

    public void transfer(double amount, BankAccount other) {
        if (other == null) {
            throw new NullPointerException("Other account must not be null");
        }
        withdraw(amount);
        other.deposit(amount);
    }

    public void addInterest() {
        balance = balance * (1 + interestRate);
    }

    public double getBalance() {
        return balance;
    }
    //ka fin de b
} 