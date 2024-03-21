package Customer;

import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer{
    private final List<Dependent> dependentList = new ArrayList<>();


    public PolicyHolder(String fullName) {
        super(fullName);
    }

    public void addDependent(Dependent dependent) {
        dependentList.add(dependent);
    }
}
