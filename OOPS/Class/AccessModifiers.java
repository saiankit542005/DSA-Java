package Class;

public class AccessModifiers {
    public static void main(String[] args) {
        BankAccount b1 = new BankAccount();
        b1.accountHolderName = "Ankit Saini";
        b1.bankName = "Bank of India";
        b1.accountType = "Saving";
        b1.accountStatus = "Active";
        b1.mobileNumber = "9785946966";
        b1.emailId = "saiankit542005@gmail.com";

        b1.setAccountNumber(9876543210L);
        b1.setPassword("ankit@bank");
        b1.setBalance(4590.34);

        System.out.println("===== Account Details ====");
        System.out.println("Bank Name : " + b1.bankName);
        System.out.println("Account Number : " + b1.getAccountNumber());
        System.out.println("Account Holder Name : " + b1.accountHolderName);
        System.out.println("Mobile No. : " + b1.mobileNumber);
        System.out.println("Balance : " + b1.getBalance());
        System.out.println("Email Id : " + b1.emailId);
        System.out.println("Password : " + b1.getPassword());
        System.out.println("Account status : " + b1.accountStatus);
        System.out.println("Account Type : " + b1.accountType);
    }

}

class BankAccount {
    private long accountNumber;
    private String password;
    private double balance;
    String accountHolderName;
    public String bankName;
    String accountType;
    protected String mobileNumber;
    protected String emailId;
    String accountStatus;

    void setAccountNumber(long acN) {
        accountNumber = acN;
    }

    long getAccountNumber() {
        return this.accountNumber;
    }

    void setPassword(String pass) {
        password = pass;
    }

    String getPassword() {
        return this.password;
    }

    void setBalance(double bal) {
        balance = bal;
    }

    double getBalance() {
        return this.balance;
    }

}
