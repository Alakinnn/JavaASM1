package Claim;

/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import Database.Recordable;
import Receiver.Receiver;
import Utils.DateFormatter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Represents a claim made by an insured person.
 * Implements Recordable and Serializable interfaces.
 */
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

    /**
     * Constructor for creating a Claim object.
     *
     * @param insuredPersonId   The ID of the insured person.
     * @param cardNumber        The card number associated with the claim.
     * @param examDate          The date of the examination related to the claim.
     * @param claimAmount       The amount of the claim.
     * @param statusOrdinal     The ordinal value of the claim status.
     * @param receiverBank      The bank associated with the claim receiver.
     * @param receiverName      The name of the claim receiver.
     * @param receiverBankNumber The bank account number of the claim receiver.
     */

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

    /**
     * Gets the ID of the insured person associated with the claim.
     *
     * @return The ID of the insured person.
     */
    public String getInsuredPersonId() {
        return insuredPersonId;
    }

    /**
     * Gets the list of documents related to the claim.
     *
     * @return The list of documents.
     */
    public List<String> getDocuments() {
        return documents;
    }

    /**
     * Adds a document to the list of documents related to the claim.
     *
     * @param document The document to be added.
     */
    public void addDocument(String document) {
        documents.add(document);
    }

    /**
     * Sets the status of the claim.
     *
     * @param statusOrdinal The ordinal value of the claim status.
     */
    public void setStatus(int statusOrdinal) {
        if (statusOrdinal != status.ordinal()) {
            this.status = Status.values()[statusOrdinal];
        }
    }

    /**
     * Retrieves the ID of the claim.
     *
     * @return The ID of the claim.
     */
    @Override
    public String getID() {
        return this.id;
    }

    /**
     * Generates and sets a unique ID for the claim.
     *
     * @return The generated ID.
     */
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

    /**
     * Returns a string representation of the claim object.
     *
     * @return A string containing the claim details.
     */
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
