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
public class Modul7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Customer aCustomer = new Customer("Jens Hansen", 1, 15678.46);
        Customer anotherCustomer = new Customer("Alan Smithee", 1);
        aCustomer.deposit(651.98);
        aCustomer.withdraw(555.98);
        anotherCustomer.deposit(653.64);
        anotherCustomer.withdraw(81);
        System.out.println("Balance for " + aCustomer.getName() + ": " + aCustomer.getBalance());

        CustomerDatabase customers = new CustomerDatabase();
        Customer[] customerArr = customers.getCustomers();
        System.out.println("All names in database");
        for (Customer customer : customerArr) {
            if (customer != null) {
                System.out.println(customer.getName());
            }
        }
        customers.saveCustomer(aCustomer);
        customers.saveCustomer(anotherCustomer);
        System.out.println("Added 2 customers, lets review the list of names");
        customers.printNames();
        customers.deleteCustomer(3);
        System.out.println("Deleted a customer, lets review the list of names again");
        customers.printNames();
    }

}
