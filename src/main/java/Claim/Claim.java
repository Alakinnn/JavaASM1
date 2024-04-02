package Claim;

import Datebase.Recordable;
import Receiver.Receiver;
import Utils.DateFormatter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Claim implements Recordable, Serializable {
    private static final long serialVersionUID = 987654321L;
    private static final Set<String> existingIds = new HashSet<>();
    private String id = "f";
    private LocalDate claimDate;
    private String insuredPersonId;
    private String cardNumber;
    private LocalDate examDate;
    private List<String> documents = new ArrayList<>();
    private double claimAmount;
    private Status status;
    private Receiver receiver;

    public Claim(String insuredPersonId, String cardNumber, String examDate, double claimAmount, int statusOrdinal, String receiverBank, String receiverName, String receiverBankNumber) {
        this.id = setID();
        this.claimDate = LocalDate.now();
        this.insuredPersonId = insuredPersonId;
        this.cardNumber = cardNumber;
        this.examDate = DateFormatter.parseDate(examDate);
        this.claimAmount = claimAmount;
        this.status = Status.values()[statusOrdinal];
        this.receiver = new Receiver(receiverBank, receiverName, receiverBankNumber);
    }

    public LocalDate getClaimDate() {
        return claimDate;
    }

    public String getInsuredPersonId() {
        return insuredPersonId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public Status getStatus() {
        return status;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public boolean addDocument(String document) {
        documents.add(document);
        return true;
    }
    public boolean setStatus(int statusOrdinal) {
        if (statusOrdinal != status.ordinal()) {
            this.status = Status.values()[statusOrdinal];
            return true;
        } return false;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String setID() {
        String ranId;
        do {
            ranId = generateID();
        } while (existingIds.contains(this.id + ranId));
        ranId = this.id + ranId;
        existingIds.add(ranId);
        return ranId;
    }

    @Override
    public String toString() {
        return "Claim ID: " + id + "\n" +
                "Claim Date: " + claimDate + "\n" +
                "Insured Person ID: " + insuredPersonId + "\n" +
                "Card Number: " + cardNumber + "\n" +
                "Exam Date: " + examDate + "\n" +
                "Claim Amount: " + claimAmount + "\n" +
                "Status: " + status + "\n" +
                "Receiver: " + receiver + "\n" +
                "Number of Documents: " + getDocuments().size() + "\n";
    }

}
