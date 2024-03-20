package Customer;

import Claim.Claim;
import Datebase.Recordable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Customer implements Recordable {
    private static final Set<String> existingIds = new HashSet<>();
    private String id;
    private String fullName;
    private String insuranceCardID;
    private final List<Claim> claimList = new ArrayList<>();

    public Customer(String fullName, String insuranceCardID) {
        this.id = setID();
        this.fullName = fullName;
        this.insuranceCardID = insuranceCardID;
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
