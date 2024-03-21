package Claim;

import Datebase.RecordManager;

import java.util.List;

public interface ClaimProcessManager {
    static void add(String insuredPersonId, String cardNumber, String examDate, double claimAmount, int statusOrdinal, String receiverBank, String receiverName, String receiverBankNumber, String document, RecordManager rm) {

        Claim newClaim = new Claim(insuredPersonId, cardNumber, examDate, claimAmount, statusOrdinal, receiverBank, receiverName, receiverBankNumber, document);
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
    };
    void delete(String claimId, RecordManager rm);
    Claim getOne(String claimId, RecordManager rm);
    List<Claim> getAll(RecordManager rm);
}
