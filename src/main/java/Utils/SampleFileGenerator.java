package Utils;
import Database.*;

public class SampleFileGenerator {
    public static void generateSampleFile() {
        SampleDataGenerator sdg = new SampleDataGenerator();
        FileOperations.write(sdg.getSampleCards(), "src/main/resources/insuranceCards.txt");
        FileOperations.write(sdg.getSampleClaims(), "src/main/resources/claims.txt");
        FileOperations.write(sdg.getSampleCustomers(), "src/main/resources/customers.txt");
    }
}
