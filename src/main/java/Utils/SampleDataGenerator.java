package Utils;

import Claim.*;
import Customer.*;
import InsuranceCard.InsuranceCard;

import java.util.ArrayList;
import java.util.List;
// This class was made so file can be created
public class SampleDataGenerator {

    private final List<Customer> sampleCustomers = new ArrayList<>();
    private final List<InsuranceCard> sampleCards = new ArrayList<>();
    private final List<Claim> sampleClaims = new ArrayList<>();

    public SampleDataGenerator() {
        PolicyHolder holder1 = new PolicyHolder("John Smith");
        PolicyHolder holder2 = new PolicyHolder("Mary Johnson");
        PolicyHolder holder3 = new PolicyHolder("Michael Williams");
        PolicyHolder holder4 = new PolicyHolder("Jennifer Jones");
        PolicyHolder holder5 = new PolicyHolder("David Brown");
        PolicyHolder holder6 = new PolicyHolder("Linda Davis");
        PolicyHolder holder7 = new PolicyHolder("James Miller");
        PolicyHolder holder8 = new PolicyHolder("Susan Wilson");
        PolicyHolder holder9 = new PolicyHolder("Robert Moore");
        PolicyHolder holder10 = new PolicyHolder("Karen Taylor");
        PolicyHolder holder11 = new PolicyHolder("Emily Anderson");
        PolicyHolder holder12 = new PolicyHolder("Daniel Martinez");
        PolicyHolder holder13 = new PolicyHolder("Alice Johnson");
        PolicyHolder holder14 = new PolicyHolder("Benjamin Smith");
        PolicyHolder holder15 = new PolicyHolder("Chloe Davis");

        holder1.addDependent("Emma Adams");
        holder1.addDependent("Alexander Lee");

        holder2.addDependent("Grace Walker");

        holder5.addDependent("Henry Harris");

        holder8.addDependent("Sophia Carter");

        holder11.addDependent("William Moore");

        sampleCustomers.add(holder1);
        sampleCustomers.add(holder2);
        sampleCustomers.add(holder3);
        sampleCustomers.add(holder4);
        sampleCustomers.add(holder5);
        sampleCustomers.add(holder6);
        sampleCustomers.add(holder7);
        sampleCustomers.add(holder8);
        sampleCustomers.add(holder9);
        sampleCustomers.add(holder10);
        sampleCustomers.add(holder11);
        sampleCustomers.add(holder12);
        sampleCustomers.add(holder13);
        sampleCustomers.add(holder14);
        sampleCustomers.add(holder15);

        Claim claim1 = new Claim(holder1.getID(), holder1.getInsuranceCard().getID(), "2024-03-01", 1000.0, Status.NEW.ordinal(), "BankA", "John Doe", "1234567890");
        sampleClaims.add(claim1);

        Claim claim2 = new Claim(holder1.getID(), holder1.getInsuranceCard().getID(), "2024-03-05", 1500.0, Status.NEW.ordinal(), "BankB", "Jane Smith", "0987654321");
        sampleClaims.add(claim2);

        Claim claim3 = new Claim(holder1.getID(), holder1.getInsuranceCard().getID(), "2024-03-10", 2000.0, Status.NEW.ordinal(), "BankC", "David Johnson", "1357924680");
        sampleClaims.add(claim3);

        Claim claim4 = new Claim(holder2.getID(), holder2.getInsuranceCard().getID(), "2024-03-02", 1200.0, Status.NEW.ordinal(), "BankX", "Alice Brown", "9876543210");
        sampleClaims.add(claim4);

        Claim claim5 = new Claim(holder2.getID(), holder2.getInsuranceCard().getID(), "2024-03-06", 1800.0, Status.NEW.ordinal(), "BankY", "Ethan Wilson", "0123456789");
        sampleClaims.add(claim5);

        Claim claim6 = new Claim(holder2.getID(), holder2.getInsuranceCard().getID(), "2024-03-11", 2200.0, Status.NEW.ordinal(), "BankZ", "Sophia Lee", "2468013579");
        sampleClaims.add(claim6);

        Claim claim7 = new Claim(holder3.getID(), holder3.getInsuranceCard().getID(), "2024-03-03", 1300.0, Status.NEW.ordinal(), "BankM", "Olivia Taylor", "5432167890");
        sampleClaims.add(claim7);

        Claim claim8 = new Claim(holder3.getID(), holder3.getInsuranceCard().getID(), "2024-03-07", 1700.0, Status.NEW.ordinal(), "BankN", "Noah Garcia", "6789054321");
        sampleClaims.add(claim8);

        Claim claim9 = new Claim(holder3.getID(), holder3.getInsuranceCard().getID(), "2024-03-12", 2400.0, Status.NEW.ordinal(), "BankO", "Ava Martinez", "7890123456");
        sampleClaims.add(claim9);

        Claim claim10 = new Claim(holder4.getID(), holder4.getInsuranceCard().getID(), "2024-03-04", 1100.0, Status.NEW.ordinal(), "BankP", "Liam Anderson", "8901234567");
        sampleClaims.add(claim10);

        Claim claim11 = new Claim(holder4.getID(), holder4.getInsuranceCard().getID(), "2024-03-08", 1600.0, Status.NEW.ordinal(), "BankQ", "Mia Clark", "9012345678");
        sampleClaims.add(claim11);

        Claim claim12 = new Claim(holder4.getID(), holder4.getInsuranceCard().getID(), "2024-03-13", 2300.0, Status.NEW.ordinal(), "BankR", "Lucas Adams", "0123456789");
        sampleClaims.add(claim12);

        holder1.addClaimList(claim1);
        holder1.addClaimList(claim2);
        holder1.addClaimList(claim3);

        holder2.addClaimList(claim4);
        holder2.addClaimList(claim5);
        holder2.addClaimList(claim6);

        holder3.addClaimList(claim7);
        holder3.addClaimList(claim8);
        holder3.addClaimList(claim9);

        holder4.addClaimList(claim10);
        holder4.addClaimList(claim11);
        holder4.addClaimList(claim12);


        for (Customer customer : sampleCustomers) {
            sampleCards.add(customer.getInsuranceCard());
        }



    }

    public List<Customer> getSampleCustomers() {
        return sampleCustomers;
    }

    public List<InsuranceCard> getSampleCards() {
        return sampleCards;
    }

    public List<Claim> getSampleClaims() {
        return sampleClaims;
    }
}
