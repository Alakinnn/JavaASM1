package InsuranceCard;

import Datebase.Recordable;
import Utils.DateFormatter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class InsuranceCard implements Recordable {
    public static String[] POLICY_OWNERS = {"PKL", "KPO", "FLO", "AOS"};
    private static Set<String> existingNumbers = new HashSet<>();
    private String cardNumber = "";
    private String cardHolder;
    private String policyOwner;
    private LocalDate expirationDate;

    public InsuranceCard(String cardHolder, String policyOwner, String expirationDate) {
        this.cardNumber = setID();
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = DateFormatter.parseDate(expirationDate);
    }

    @Override
    public String getID() {
        return this.cardNumber;
    }

    @Override
    public String setID() {
        String ranId;
        do {
            ranId = generateID();
        } while (existingNumbers.contains(this.cardNumber + ranId));
        ranId = this.cardNumber + ranId;
        existingNumbers.add(ranId);
        return ranId;
    }
}
