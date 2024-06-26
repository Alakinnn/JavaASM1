package InsuranceCard;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import Customer.*;
import Database.Recordable;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;


/**
 * Represents an insurance card.
 * Implements the Recordable interface.
 *
 * <p>
 * Insurance cards are associated with a card holder and have a unique card number.
 * </p>
 *
 * <p>
 * Note: This class is serializable.
 * </p>
 */
public class InsuranceCard implements Recordable, Serializable {

    private static final long serialVersionUID = 345678901L;
    private static final String[] POLICY_OWNERS = {"PKL", "KPO", "FLO", "AOS"};
    private static final Random RANDOM = new Random();
    private static final Set<String> existingNumbers = new HashSet<>();

    private String cardNumber = "";
    private final Customer cardHolder;
    private final String policyOwner;
    private final LocalDate expirationDate;

    /**
     * Constructs an insurance card associated with the specified card holder.
     *
     * @param cardHolder The customer associated with the insurance card.
     */
    public InsuranceCard(Customer cardHolder) {
        this.cardNumber = setID();
        this.cardHolder = cardHolder;
        this.expirationDate = generateRandomExpirationDate();
        this.policyOwner = POLICY_OWNERS[RANDOM.nextInt(POLICY_OWNERS.length)];
    }

    /**
     * Gets the card number of the insurance card.
     *
     * @return The card number of the insurance card.
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Generates a random expiration date for the insurance card.
     *
     * @return The expiration date of the insurance card.
     */
    private LocalDate generateRandomExpirationDate() {
        // Generate random year within the next 10 years
        int year = LocalDate.now().getYear() + RANDOM.nextInt(10);

        // Generate random month (1-12)
        int month = RANDOM.nextInt(12) + 1;

        // Generate random day (1-28/29/30/31 depending on month)
        int day = RANDOM.nextInt(LocalDate.of(year, month, 1).lengthOfMonth()) + 1;

        return LocalDate.of(year, month, day);
    }

    /**
     * Gets the ID of the insurance card.
     *
     * @return The ID of the insurance card.
     */
    @Override
    public String getID() {
        return this.cardNumber;
    }

    /**
     * Sets a unique ID for the insurance card.
     *
     * @return The generated ID as a string.
     */
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

    /**
     * Returns a string representation of the insurance card.
     *
     * @return A string representation of the insurance card.
     */
    @Override
    public String toString() {
        return
                "Card Number: " + cardNumber + '\n' +
                        "Card Holder: " + cardHolder.getFullName() + '\n' +
                        "Policy Owner: " + policyOwner + '\n' +
                        "Expiration Date: " + expirationDate + '\n'
                ;
    }
}
