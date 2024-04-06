package Customer;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import Claim.*;
import Database.Recordable;
import InsuranceCard.InsuranceCard;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Abstract class representing a customer.
 * Provides methods for managing customer details and claims.
 * Implements Recordable and Serializable interfaces.
 * Implements ClaimProcessManager interface for claim management.
 */
public abstract class Customer implements Recordable, ClaimProcessManager, Serializable {

    @Serial
    private static final long serialVersionUID = 456789012L;

    private static final Set<String> existingIds = new HashSet<>();
    private String id = "c";
    private final String fullName;
    private final InsuranceCard insuranceCard = new InsuranceCard(this);
    private final List<Claim> claimList = new ArrayList<>();

    /**
     * Constructs a customer with the specified full name.
     *
     * @param fullName The full name of the customer.
     */
    public Customer(String fullName) {
        this.id = setID();
        this.fullName = fullName;
    }

    /**
     * Gets the full name of the customer.
     *
     * @return The full name of the customer.
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Gets the insurance card of the customer.
     *
     * @return The insurance card of the customer.
     */
    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    /**
     * Gets the list of claims associated with the customer.
     *
     * @return The list of claims associated with the customer.
     */
    public List<Claim> getClaimList() {
        return claimList;
    }

    /**
     * Adds a claim to the list of claims associated with the customer.
     *
     * @param claim The claim to be added.
     */
    public void addClaimList(Claim claim) {
        this.claimList.add(claim);
    }

    /**
     * Retrieves the ID of the customer.
     *
     * @return The ID of the customer.
     */
    @Override
    public String getID() {
        return this.id;
    }

    /**
     * Generates and sets a unique ID for the customer.
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
     * Returns a string representation of the customer object.
     *
     * @return A string containing the customer details.
     */
    @Override
    public String toString() {
        return "Customer name: " + getFullName() + "\n" +
                "Customer ID: " + getID() + "\n" +
                "Insurance Card Number: " + getInsuranceCard().getCardNumber() + "\n" +
                "Number of claims: " + getClaimList().size() + "\n";
    }
}
