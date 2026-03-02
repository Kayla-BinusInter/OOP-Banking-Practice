package Banking;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers = new ArrayList<>();
    private String bankName;
    private static int numberOfCustomers;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void addCustomer(String f, String l){
        customers.add(new Customer(f,l));
        numberOfCustomers++;
    }

    public Customer searchCustomer(String firstName) {
        for (Customer c : customers) {
            if (c.getFirstName().equalsIgnoreCase(firstName)) {
                return c;
            }
        }
        return null;
    }

    public boolean deleteCustomer(String firstName) {
        Customer c = searchCustomer(firstName);
        if (c != null) {
            customers.remove(c);
            numberOfCustomers--;
            return true;
        }
        return false;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public int getNumberOfCustomers(){
        return numberOfCustomers;
    }

    public Customer getCustomer(int index){
        return customers.get(index);
    }

    public String getBankName() {
        return bankName;
    }
}