package accountmanagement.services;
import accountmanagement.Repositry.BankAccount;

import java.util.Random;
import java.util.Scanner;

public class AccountsServices {
    public static BankAccount createAccount(Scanner scanner){
        System.out.print("Please enter your name :  ");
        String name = scanner.next();
        scanner.nextLine();
        Random rand = new Random();
        long accountNum = rand.nextLong(9999999999999999L);
        System.out.print("please enter your balance :  ");
        double balance = scanner.nextDouble();
        scanner.nextLine();
        return new BankAccount(String.valueOf(accountNum),name,balance);
    }
    // helper method to check the name only contains characters
    private boolean isContainsNums(String name) {
        return  name.contains("1,2,3,4,5,6,7,8,9,0");
    }
}
