package Customer;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

/**
 * Represents a dependent customer.
 * Extends the Customer class.
 *
 * <p>
 * Dependent customers are associated with a policy holder.
 * They inherit properties and methods from the Customer class.
 * </p>
 */
public class Dependent extends Customer {

    private PolicyHolder policyHolder;

    /**
     * Constructs a dependent customer with the specified full name.
     *
     * @param fullName The full name of the dependent customer.
     */
    public Dependent(String fullName) {
        super(fullName);
    }

    /**
     * Sets the policyholder associated with the dependent customer.
     *
     * @param policyHolder The policyholder to be set.
     */
    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    /**
     * Gets the policyholder associated with the dependent customer.
     *
     * @return The policyholder associated with the dependent customer.
     */
    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }
}
