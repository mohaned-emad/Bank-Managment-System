/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mysuperbank;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Mohaned
 */
public class Account implements ITransaction {
    private String name;
    private String city;
    private String Phone;
    private String Gender;
    private String pass;
    private double balance;
    private int age;
    private ArrayList<Transaction> allTransactions = new ArrayList<>();

    public Account(String name, String city, String Phone, String Gender, String pass, int age, double balance) {
        this.name = name;
        this.city = city;
        this.Phone = Phone;
        this.Gender = Gender;
        this.pass = pass;
        this.age = age;
        deposit(balance, LocalDateTime.now());
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return Phone;
    }

    public String getGender() {
        return Gender;
    }

    public String getPass() {
        return pass;
    }

    public double getBalance() {
        balance = 0;
        for (var item : allTransactions)
            balance += item.getMoney();
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setBalance(double money) {
        this.balance = money;
    }

    public int getAge() {
        return age;
    }
    
    @Override
    public void deposit(double money, LocalDateTime dateTime){
        Transaction t = new Transaction(money, dateTime);
        allTransactions.add(t);
    }
    
    @Override
    public void withdraw(double money, LocalDateTime dateTime){
        Transaction t = new Transaction(-money, dateTime);
        allTransactions.add(t);
    }
    
}
