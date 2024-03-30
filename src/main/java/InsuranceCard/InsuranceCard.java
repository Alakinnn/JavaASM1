package InsuranceCard;

import Customer.*;
import Datebase.Recordable;
import Utils.DateFormatter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class InsuranceCard implements Recordable {
    private static String[] POLICY_OWNERS = {"PKL", "KPO", "FLO", "AOS"};
    private static Random RANDOM = new Random();
    private static Set<String> existingNumbers = new HashSet<>();
    private String cardNumber = "";
    private Customer cardHolder;
    private String policyOwner;
    private LocalDate expirationDate;

    public InsuranceCard(Customer cardHolder) {
        this.cardNumber = setID();
        this.cardHolder = cardHolder;
        this.expirationDate = generateRandomExpirationDate();
        this.policyOwner = POLICY_OWNERS[RANDOM.nextInt(POLICY_OWNERS.length)];
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(String policyOwner) {
        this.policyOwner = policyOwner;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    private LocalDate generateRandomExpirationDate() {
        // Generate random year within the next 10 years
        int year = LocalDate.now().getYear() + RANDOM.nextInt(10);

        // Generate random month (1-12)
        int month = RANDOM.nextInt(12) + 1;

        // Generate random day (1-28/29/30/31 depending on month)
        int day = RANDOM.nextInt(LocalDate.of(year, month, 1).lengthOfMonth()) + 1;

        return LocalDate.of(year, month, day);
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
