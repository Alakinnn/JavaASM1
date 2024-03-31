package Customer;

import java.io.Serializable;

class Dependent extends Customer {
    private PolicyHolder policyHolder;

     Dependent(String fullName) {
        super(fullName);
    }

     void setPolicyHolder(PolicyHolder policyHolder) {
        this.policyHolder = policyHolder;
    }
}
