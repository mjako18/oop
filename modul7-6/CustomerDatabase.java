/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul7;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Mathias
 */
public class CustomerDatabase {

    private Customer[] customers;
    private String[] names = {"John Doe", "Yvonne Børgesen", "Dynamit Harry", "Egon Olsen", "Gummi Tarzan", "Peanut Dunham", "John Shepard"};

    public CustomerDatabase() {
        customers = new Customer[10];
        for (int i = 0; i < 7; i++) {
            customers[i] = new Customer(names[i], i);
        }
    }

    public void saveCustomer(Customer custObj) {
        for (int i = 0; i < this.customers.length; i++) {
            if (this.customers[i] == null) {
                this.customers[i] = custObj;
                break;
            }
        }
    }

    public void deleteCustomer(int id) {
        for (int i = 0; i < this.customers.length; i++) {
            if (this.customers[i] != null) {
                if (this.customers[i].getId() == id) {
                    this.customers[i] = null;
                }
            }
        }
    }

    public Customer[] getCustomers() {
        return this.customers;
    }

    public void printNames() {
        for (Customer customer : this.customers) {
            if (customer != null) {
                System.out.println(customer.getName());
            }
        }
    }
}
