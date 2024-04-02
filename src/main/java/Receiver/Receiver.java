package Receiver;

import java.io.Serial;
import java.io.Serializable;

public class Receiver implements Serializable {
    @Serial
    private static final long serialVersionUID = 234567890L;
    private String bankName;
    private String accountName;
    private String accountNumber;

    public Receiver(String bankName, String accountName, String accountNumber) {
        this.bankName = bankName;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return getAccountName() + " - " + getBankName() + " - " + getAccountNumber();
    }
}
