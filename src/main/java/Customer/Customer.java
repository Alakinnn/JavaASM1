package Customer;

import Claim.*;
import Datebase.Recordable;
import InsuranceCard.InsuranceCard;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Customer implements Recordable, ClaimProcessManager, Serializable {
    @Serial
    private static final long serialVersionUID = 456789012L;
    private static final Set<String> existingIds = new HashSet<>();
    private String id = "c";
    private final String fullName;
    private final InsuranceCard insuranceCard = new InsuranceCard(this);
    private final List<Claim> claimList = new ArrayList<>();

    public Customer(String fullName) {
        this.id = setID();
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public List<Claim> getClaimList() {
        return claimList;
    }

    public void addClaimList(Claim claim) {
        this.claimList.add(claim);
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
        return "Customer name: " + getFullName() + "\n" +
                "Customer ID: " + getID() + "\n" +
                "Insurance Card Number: " + getInsuranceCard().getCardNumber() + "\n" +
                "Number of claims: " + getClaimList().size() + "\n"
                ;
    }
}
