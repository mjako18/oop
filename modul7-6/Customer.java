/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul7;

/**
 *
 * @author Mathias
 */
public class Customer {

    private String name;
    private int id;
    private double balance;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
        this.balance = 0.0;
    }

    public Customer(String name, int id, double balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }
    
    public void deposit(double amount) {
        this.balance += amount;
    }
    
    public void withdraw(double amount) {
        if(this.balance > amount) {
            this.balance -= amount;
        }
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
}
