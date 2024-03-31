package Claim;

import Customer.Customer;
import Datebase.RecordManager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public interface ClaimProcessManager {
    static void add(String insuredPersonId, String cardNumber, String examDate, double claimAmount, int statusOrdinal, String receiverBank, String receiverName, String receiverBankNumber, RecordManager rm) {
        Claim newClaim = new Claim(insuredPersonId, cardNumber, examDate, claimAmount, statusOrdinal, receiverBank, receiverName, receiverBankNumber);
        Customer customer = (Customer) rm.find(insuredPersonId);
        customer.addClaimList(newClaim);
        rm.add(newClaim);

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
