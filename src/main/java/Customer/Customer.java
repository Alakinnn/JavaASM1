package Customer;

import Claim.*;
import Datebase.RecordManager;
import Datebase.Recordable;
import InsuranceCard.InsuranceCard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Customer implements Recordable, ClaimProcessManager {
    private static final Set<String> existingIds = new HashSet<>();
    private String id;
    private String fullName;
    private InsuranceCard insuranceCard = new InsuranceCard(this);
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
