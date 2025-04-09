package com.example.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount account;
    private BankAccount otherAccount;

    @BeforeEach
    void setUp() {
        account = new BankAccount(1000.0, 0.05); // 5% interest rate
        otherAccount = new BankAccount(500.0, 0.05);
    }

    @Test
    void deposit_WithPositiveAmount_ShouldIncreaseBalance() {
        account.deposit(500.0);
        assertEquals(1500.0, account.getBalance());
    }

    @Test
    void deposit_WithNegativeAmount_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-100.0));
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void withdraw_WithValidAmount_ShouldDecreaseBalance() {
        account.withdraw(300.0);
        assertEquals(700.0, account.getBalance());
    }

    @Test
    void withdraw_WithNegativeAmount_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100.0));
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void withdraw_WithInsufficientBalance_ShouldThrowException() {
        assertThrows(IllegalStateException.class, () -> account.withdraw(1500.0));
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void transfer_WithValidAmount_ShouldTransferMoney() {
        account.transfer(300.0, otherAccount);
        assertEquals(700.0, account.getBalance());
        assertEquals(800.0, otherAccount.getBalance());
    }

    @Test
    void transfer_WithNullAccount_ShouldThrowException() {
        assertThrows(NullPointerException.class, () -> account.transfer(300.0, null));
        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void transfer_WithInsufficientBalance_ShouldThrowException() {
        assertThrows(IllegalStateException.class, () -> account.transfer(1500.0, otherAccount));
        assertEquals(1000.0, account.getBalance());
        assertEquals(500.0, otherAccount.getBalance());
    }

    @Test
    void addInterest_ShouldApplyInterestRate() {
        account.addInterest();
        assertEquals(1050.0, account.getBalance()); // 1000 * (1 + 0.05)
    }
} 