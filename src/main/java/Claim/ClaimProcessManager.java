package Claim;

import Customer.Customer;
import Datebase.RecordManager;
import Datebase.RecordOperations;
import Datebase.Recordable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface ClaimProcessManager {
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

    static void update(String claimId, RecordManager rm, String choices) {
        Claim claim = (Claim) rm.find(claimId);
        String[] choiceTokens = choices.split(" ");
        int updateChoice = Integer.parseInt(choiceTokens[0]);
        if (updateChoice == 1) {
            int statusChoice = Integer.parseInt(choiceTokens[-1]);
            claim.setStatus(statusChoice);
        } else {
            claim.addDocument(choiceTokens[-1]);
        }
        rm.updateRecords(claim);
    };

    static void delete(String claimId, RecordManager rm) {
        rm.delete(claimId);
    };

    static void getAll(String customerID, RecordManager rm) {
        Customer customer = (Customer) rm.find(customerID);
        if (customer != null) {
            Iterator<Claim> iterator = customer.getClaimList().iterator();
            while (iterator.hasNext())  {
                System.out.println(iterator.next());
            }
        }
    };
}
