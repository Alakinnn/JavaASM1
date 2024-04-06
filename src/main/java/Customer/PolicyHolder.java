package Customer;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a policyholder customer.
 * Extends the Customer class.
 *
 * <p>
 * Policy holder customers can have dependent customers associated with them.
 * They inherit properties and methods from the Customer class.
 * </p>
 */
public class PolicyHolder extends Customer {

    private final List<Dependent> dependentList = new ArrayList<>();

    /**
     * Constructs a policyholder customer with the specified full name.
     *
     * @param fullName The full name of the policyholder customer.
     */
    public PolicyHolder(String fullName) {
        super(fullName);
    }

    /**
     * Adds a dependent customer to the list of dependents associated with the policy holder.
     *
     * @param dependent The dependent customer to be added.
     */
    public void addDependent(Dependent dependent) {
        if (dependent.getPolicyHolder() != null) {
            System.out.println("Dependent already associated with a policy holder!");
        }
        dependentList.add(dependent);
        dependent.setPolicyHolder(this);
    }
}

