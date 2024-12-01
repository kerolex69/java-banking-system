package accountmanagement.Repositry;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

//String.valueOf(((long) (9000000000000000L+Math.random()*1000000000000000L)))
public class BankAccount {
    //    private parameters for encapsulation
    private String accountNumber ;
    private String accountHolderName;
    private double balance ;
    private List<String> transactions;
    final double fee =5 ;
    //    define a constructor
    public  BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        balance = initialBalance;
    }
    //    create setter & getter method

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getBalance() {
        return getCurrencyInEGP(balance);
    }

    public List<String> getTransactions() {
        return transactions;
    }
    // helper methods
    private boolean isLessThan(double amount){
        return amount<=0;
    }
//    private boolean isContainsNums(String name) {
//        return  name.contains("1,2,3,4,5,6,7,8,9,0");
//    }
    // A method used to make a deposit
    public void makeDeposit (double amount){
        if (isLessThan(amount)) {
            System.out.println("Failed to make the process.");
            throw new  IllegalArgumentException("The deposit amount must be positive.");
        }
        balance += amount ;
    }

    // A method used to make a withdraw
    public void makeWithdraw(double amount ) {
        if (balance < amount || isLessThan(amount)){
            System.out.println("Failed to make the process .");
            throw new  IllegalArgumentException("The with draw amount must be positive and balance is greater than withdraw amount.");
        }
        else
          balance -= (amount+fee) ;
    }
    // A method used to convert the balance into EGP
    protected String getCurrencyInEGP(double value){
        NumberFormat currency =NumberFormat.getCurrencyInstance(new Locale("EN","EG"));
        return currency.format(balance);
    }


    @Override
    public String toString() {
        return "BankAccount{" +"\n"+
                  "accountNumber='" + accountNumber + '\'' +"\n"+
                ", accountHolderName='" + accountHolderName + '\'' +"\n"+
                ", balance=" + getCurrencyInEGP(balance)  +"\n"+
                ", transactions=" + transactions +"\n"+
                '}';
    }

}
