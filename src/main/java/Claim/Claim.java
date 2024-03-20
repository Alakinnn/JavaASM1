package Claim;

import Datebase.Recordable;
import Receiver.ReceiverInfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Claim  implements Recordable {
    private static final Set<String> existingIds = new HashSet<>();
    private String id = "f";
    private LocalDate claimDate;
    private String insuredPersonId;
    private String cardNumber;
    private LocalDate examDate;
    private List<String> documents;
    private double claimAmount;
    private Status status;
    private ReceiverInfo receiver;

    public Claim(String id, LocalDate claimDate, String insuredPersonId, String cardNumber, LocalDate examDate, List<String> documents, double claimAmount, int statusOrdinal, String receiverBank, String receiverName, String receiverBankNumber) {
        this.id = id;
        this.claimDate = claimDate;
        this.insuredPersonId = insuredPersonId;
        this.cardNumber = cardNumber;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = Status.values()[statusOrdinal];
        this.receiver= new ReceiverInfo(receiverBank, receiverName, receiverBankNumber);
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public String setID() {
        do {
            id = generateID();
        } while (existingIds.contains("f" + id));
        id = this.id + id;
        existingIds.add(id);
        return id;
    }
}
