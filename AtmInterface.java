import java.util.InputMismatchException;
import java.util.Scanner;

class UserBankAccount {

    int balance = 1000;

    void withdraw(int amount) {
        if (balance < amount) {
            System.out.println("Insufficient balance for withdrawal");
        } else {
            balance -= amount;
            if (balance < 300) {
                System.out.println("Maintain minimum balance of 300");
            } else {
                System.out.println("Withdrawal Successful!!");
            }
        }
    }

    void deposit(int amount) {
        balance += amount;
        System.out.println("Deposit Successful!!");
    }

    void checkBalance() {
        System.out.println("Your balance: " + balance);
    }
}

class ATM extends UserBankAccount {

    private int input;

    void choice() {
        Scanner ans = new Scanner(System.in);

        while (true) {
            System.out.println("Select the choice:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check balance");
            System.out.println("4. Exit");

            try {
                input = ans.nextInt();

                switch (input) {
                    case 1:
                        System.out.println("Enter the amount you want to withdraw");
                        int withdrawAmount = ans.nextInt();
                        if (withdrawAmount > 7000) {
                            System.out.println("Limit of withdrawal at a time is 7000");
                        } else {
                            super.withdraw(withdrawAmount);
                        }
                        break;

                    case 2:
                        System.out.println("Enter the amount you want to deposit");
                        int depositAmount = ans.nextInt();
                        if (depositAmount > 10000) {
                            System.out.println("Limit of deposit at a time is 10000");
                        } else {
                            super.deposit(depositAmount);
                        }
                        break;

                    case 3:
                        super.checkBalance();
                        break;

                    case 4:
                        System.out.println("Thank You for Visiting!!");
                        return; 

                    default:
                        System.out.println("Enter the correct choice");
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter the value in integer");
                ans.next(); 
            }
            System.out.println(); 
        }
    }
}

public class AtmInterface {
    public static void main(String[] args) {
        ATM a1 = new ATM();
        a1.choice();
    }
}
