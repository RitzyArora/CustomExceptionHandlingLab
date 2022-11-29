import CustomExceptions.AmountCreditException;
import CustomExceptions.AmountDebitException;
import CustomExceptions.MinimumBalanceException;

import java.util.Scanner;

public class BankAtmMain {


    public static void main(String[] args) {
        double amountCredit;
        double amountDebit;

        int choice;
        Scanner scan = new Scanner(System.in);
        BankAtm bankAtm=new BankAtm();
        System.out.println("--------------Welcome to ABC Bank----------------");
        System.out.println("Below is the Menu");
        System.out.println("1. Withdraw Amount");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        try {
            do {
                System.out.println("Please Enter your choice");
                choice = scan.nextInt();
                switch (choice) {
                    case 1 -> {
                        System.out.println("Enter the amount to be withdraw");
                        amountDebit = scan.nextInt();
                        bankAtm.amountDebit(amountDebit);
                    }
                    case 2 -> {
                        System.out.println("Enter the amount to be deposit");
                        amountCredit = scan.nextInt();
                        bankAtm.amountCredit(amountCredit);
                    }
                    case 3 -> bankAtm.showTotalBalance();
                    default -> {
                        System.out.println("You entered wrong choice");
                        System.exit(0);
                    }
                }

            } while (choice != 4);

        } catch (AmountDebitException | MinimumBalanceException | AmountCreditException ad) {
            System.out.println(ad.getMessage());
        }
    }
}