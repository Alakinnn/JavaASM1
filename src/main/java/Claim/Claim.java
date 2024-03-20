package Claim;

import Datebase.Recordable;
import Receiver.Receiver;
import Utils.DateFormatter;

import java.time.LocalDate;
import java.util.*;

public class Claim  implements Recordable {
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

    public Claim(String id, String claimDate, String insuredPersonId, String cardNumber, String examDate, double claimAmount, int statusOrdinal, String receiverBank, String receiverName, String receiverBankNumber, String document) {
        this.id = id;
        this.claimDate = DateFormatter.parseDate(claimDate);
        this.insuredPersonId = insuredPersonId;
        this.cardNumber = cardNumber;
        this.examDate = DateFormatter.parseDate(examDate);
        this.claimAmount = claimAmount;
        this.status = Status.values()[statusOrdinal];
        this.receiver= new Receiver(receiverBank, receiverName, receiverBankNumber);
        documents.add(document);
    }

    public void addDocument(String document) {
        documents.add(document);
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
}
