package Claim;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import Customer.Customer;
import Database.RecordManager;

/**
 * Interface for managing claim processes.
 * Provides methods for adding, updating, deleting, and retrieving claims.
 */
public interface ClaimProcessManager {
    /**
     * Adds a new claim.
     *
     * @param insuredPersonID
     * @param cardNumber
     * @param examDate
     * @param claimAmount
     * @param receiverBank
     * @param receiverName
     * @param receiverBankNumber
     * @param rm
     * @return
     */
    static Claim add(String insuredPersonID, String cardNumber, String examDate, double claimAmount, String receiverBank, String receiverName, String receiverBankNumber, RecordManager rm) {
        Claim claim = new Claim(insuredPersonID, cardNumber, examDate, claimAmount, Status.NEW.ordinal(), receiverBank, receiverName, receiverBankNumber);
        Customer customer = (Customer) rm.find(insuredPersonID);

        if (customer != null) {
            customer.addClaimList(claim);
            rm.add(claim);
        } else {
            // Handle case where customer is not found
            System.out.println("Customer not found with ID: " + claim.getInsuredPersonId());
        }
        return claim;

    }

    /**
     * Updates an existing claim.
     *
     * @param claimId      The ID of the claim to be updated.
     * @param rm           The RecordManager instance for database operations.
     * @param choices      The update choices (e.g., status change or document addition).
     */
    static void update(String claimId, RecordManager rm, String choices) {
        Claim claim = (Claim) rm.find(claimId);
        String[] choiceTokens = choices.split(" ");
        int updateChoice = Integer.parseInt(choiceTokens[0]);
        if (updateChoice == 1) {
            int statusChoice = Integer.parseInt(choiceTokens[1]);
            claim.setStatus(statusChoice);
        } else {
            claim.addDocument(choiceTokens[1]);
        }
        rm.updateRecords(claim);
    };

    /**
     * Deletes a claim.
     *
     * @param claimId      The ID of the claim to be deleted.
     * @param rm           The RecordManager instance for database operations.
     */
    static void delete(String claimId, RecordManager rm) {
        rm.delete(claimId);
    };

    /**
     * Retrieves all claims associated with a customer.
     *
     * @param customerID   The ID of the customer.
     * @param rm           The RecordManager instance for database operations.
     */
    static void getAll(String customerID, RecordManager rm) {
        Customer customer = (Customer) rm.find(customerID);
        if (customer != null) {
            for (Claim claim : customer.getClaimList()) {
                System.out.println(claim);
            }
        }
    };
}
