package Customer;

import Claim.*;
import Datebase.RecordManager;
import Datebase.Recordable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Customer implements Recordable, ClaimProcessManager {
    private static final Set<String> existingIds = new HashSet<>();
    private String id;
    private String fullName;
    private String insuranceCardNumber = null;
    private final List<Claim> claimList = new ArrayList<>();

    public Customer(String fullName) {
        this.id = setID();
        this.fullName = fullName;
    }

    public void setInsuranceCardNumber(String insuranceCardNumber) {
        this.insuranceCardNumber = insuranceCardNumber;
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
    public void delete(String claimId, RecordManager rm) {

    }

    @Override
    public Claim getOne(String claimId, RecordManager rm) {
        return null;
    }

    @Override
    public List<Claim> getAll(RecordManager rm) {
        return null;
    }
}
