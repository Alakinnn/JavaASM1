package Customer;

import java.io.Serializable;

public class Dependent extends Customer {
    private PolicyHolder policyHolder;

    public Dependent(String fullName) {
        super(fullName);
    }

    public void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }

    public PolicyHolder getPolicyHolder() {
        return policyHolder;
    }
}
