package Receiver;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a receiver for claims.
 *
 * <p>
 * A receiver is associated with a bank name, account name, and account number.
 * </p>
 *
 * <p>
 * Note: This class is serializable.
 * </p>
 */
public class Receiver implements Serializable {

    private static final long serialVersionUID = 234567890L;
    private String bankName;
    private String accountName;
    private String accountNumber;

    /**
     * Constructs a receiver with the specified bank name, account name, and account number.
     *
     * @param bankName The name of the bank.
     * @param accountName The name of the account holder.
     * @param accountNumber The account number.
     */
    public Receiver(String bankName, String accountName, String accountNumber) {
        this.bankName = bankName;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the bank name of the receiver.
     *
     * @return The bank name of the receiver.
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Gets the account name of the receiver.
     *
     * @return The account name of the receiver.
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Gets the account number of the receiver.
     *
     * @return The account number of the receiver.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Returns a string representation of the receiver.
     *
     * @return A string representation of the receiver.
     */
    @Override
    public String toString() {
        return getAccountName() + " - " + getBankName() + " - " + getAccountNumber();
    }
}
