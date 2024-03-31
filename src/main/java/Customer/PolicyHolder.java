package Customer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer {
    private final List<Dependent> dependentList = new ArrayList<>();


    public PolicyHolder(String fullName) {
        super(fullName);
    }

    public void addDependent(String dependentName) {
        Dependent dependent = new Dependent(dependentName);
        dependentList.add(dependent);
        dependent.setPolicyHolder(this);
    }
}
