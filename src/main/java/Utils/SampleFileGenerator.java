package Utils;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import Database.*;

/**
 * Generates sample data files.
 *
 * <p>
 *     This class is responsible for generating sample data files containing
 *     sample insurance cards, claims, and customers. The generated files can
 *     be used to populate the database during application development or testing.
 * </p>
 *
 * <p>
 *     Note: This class is not meant to be used directly by users.
 * </p>
 *
 */
public class SampleFileGenerator {
    public static void generateSampleFile() {
        SampleDataGenerator sdg = new SampleDataGenerator();
        FileOperations.write(sdg.getSampleCards(), "src/main/resources/insuranceCards.txt");
        FileOperations.write(sdg.getSampleClaims(), "src/main/resources/claims.txt");
        FileOperations.write(sdg.getSampleCustomers(), "src/main/resources/customers.txt");
    }
}
