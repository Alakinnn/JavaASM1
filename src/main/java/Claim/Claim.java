package Claim;

import Datebase.Recordable;
import Receiver.Receiver;
import Utils.DateFormatter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Claim implements Recordable, Serializable {
    @Serial
    private static final long serialVersionUID = 987654321L;
    private static final Set<String> existingIds = new HashSet<>();
    private String id = "f";
    private final LocalDate claimDate;
    private final String insuredPersonId;
    private final String cardNumber;
    private final LocalDate examDate;
    private final List<String> documents = new ArrayList<>();
    private final double claimAmount;
    private Status status;
    private final Receiver receiver;

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

    public void addDocument(String document) {
        documents.add(document);
    }

    public void setStatus(int statusOrdinal) {
        if (statusOrdinal != status.ordinal()) {
            this.status = Status.values()[statusOrdinal];
        }
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
