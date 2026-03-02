package Banking;

import java.util.Scanner;

public class Driver {

    static void main(){
        Scanner sc = new Scanner(System.in);
        Bank b1 = new Bank("Banku Ku");

        // Your initial test data
        b1.addCustomer("Nelson", "Fernandes");
        b1.addCustomer("Bags", "Adit");
        b1.addCustomer("Ali", "Sam");
        b1.addCustomer("Simran", "Trish");
        b1.getCustomer(0).setAccount(new Account(1500));

        boolean running = true;
        while (running) {
            System.out.println("\n=== " + b1.getBankName() + " MAIN MENU ===");
            System.out.println("1. Bank Admin\n2. Customer\n3. Exit");
            int role = sc.nextInt();

            if (role == 1) {
                System.out.println("\n[ADMIN] 1.Add 2.Search 3.Delete 4.Display 5.Create Account 6.Back");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.print("First Name: "); String f = sc.next();
                        System.out.print("Last Name: "); String l = sc.next();
                        b1.addCustomer(f, l);
                    }
                    case 2 -> {
                        System.out.print("Enter First Name: ");
                        Customer c = b1.searchCustomer(sc.next());
                        if (c != null) System.out.println("Found: " + c.getFirstName() + " " + c.getLastName());
                        else System.out.println("Not found.");
                    }
                    case 3 -> {
                        System.out.print("Name to delete: ");
                        if (b1.deleteCustomer(sc.next())) System.out.println("Deleted.");
                        else System.out.println("Not found.");
                    }
                    case 4 -> {
                        for (Customer c : b1.getCustomers())
                            System.out.println("- " + c.getFirstName() + " " + c.getLastName());
                    }
                    case 5 -> {
                        System.out.print("Customer First Name: ");
                        Customer c = b1.searchCustomer(sc.next());
                        if (c != null) {
                            System.out.print("Initial Deposit: ");
                            c.setAccount(new Account(sc.nextDouble()));
                        }
                    }
                }
            } else if (role == 2) {
                System.out.print("Enter your First Name: ");
                Customer current = b1.searchCustomer(sc.next());
                if (current != null && current.getAccount() != null) {
                    System.out.println("\n[Hi " + current.getFirstName() + "] 1.Balance 2.Deposit 3.Withdraw 4.Transfer 5.Back");
                    int choice = sc.nextInt();
                    Account acc = current.getAccount();
                    switch (choice) {
                        case 1 -> System.out.println("Balance: " + acc.getBalance());
                        case 2 -> { System.out.print("Amount: "); acc.deposit(sc.nextDouble()); }
                        case 3 -> {
                            System.out.print("Amount: ");
                            if (!acc.withdraw(sc.nextDouble())) System.out.println("Insufficient funds!");
                        }
                        case 4 -> {
                            System.out.print("Recipient First Name: ");
                            Customer target = b1.searchCustomer(sc.next());
                            System.out.print("Amount: ");
                            double amt = sc.nextDouble();
                            if (target != null && target.getAccount() != null && acc.withdraw(amt)) {
                                target.getAccount().deposit(amt);
                                System.out.println("Transfer successful!");
                            } else System.out.println("Transfer failed.");
                        }
                    }
                } else System.out.println("Account not found or not created yet.");
            } else if (role == 3) {
                running = false;
            }
        }
        System.out.println("Goodbye!");
    }

}


        /*
            Simulate a simple system that would be able to do the following transactions:
        
        Bank Admin
            1. Add Customer
            2. Search Customer (by First Name)and Display Customer Details
            3. Delete a Customer
            4. Dispay customers
            5. Create an account for a customer
        
        Customer
            1. Balance Inquiry
            2. Deposit
            3. Withdraw
            4. Transfer (to a different account)
        
        [Note: program only terminates once the admin or customer quits it]
        
        Save the files in a gitHub repo and send to jude.j.l.martinez@gmail.com on or before midnight today
        */












        /*
        Bank b1 = new Bank("Banku Ku");
        
        b1.addCustomer("Nelson", "Fernandes");
        b1.addCustomer("Bags", "Adit");
        b1.addCustomer("Ali", "Sam");
        b1.addCustomer("Simran", "Trish");
        
        System.out.println("Number of Customers: "+b1.getNumberOfCustomers());
        
        System.out.println("Customer: "+b1.getCustomer(0).getFirstName());
        
        //create an account for the customer
        
        b1.getCustomer(0).setAccount(new Account(1500));
        
        System.out.println("Created an account for "+ b1.getCustomer(0).getFirstName());
        System.out.println("with an initial balance of "+ b1.getCustomer(0).getAccount().getBalance());


















        
        
        /*Customer c1 = new Customer("Adler","Covenant");
        
        c1.setAccount(new Account(1000));
        
        System.out.println("Created an account for "+ c1.getFirstName()+" "+c1.getLastName());
        System.out.println("with an initial balance of "+ c1.getAccount().getBalance());
        
        if(c1.getAccount().withdraw(500)){
            System.out.println("Withdrawal successful: remaining balance is "+ c1.getAccount().getBalance());
        }else{
            System.out.println("Withdrawal failed: remaining balance is "+ c1.getAccount().getBalance());
        }
        
        if(c1.getAccount().deposit(500)){
            System.out.println("Deposit successful: remaining balance is "+ c1.getAccount().getBalance());
        }else{
            System.out.println("Deposit failed: remaining balance is "+ c1.getAccount().getBalance());
        }*/
