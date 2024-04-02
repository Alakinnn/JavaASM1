/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import Database.FileOperations;
import Database.RecordManager;
import UI.Program;
import Utils.SampleFileGenerator;

public class Main {
    public static void main(String[] args) {
        if (!FileOperations.fileExists("src/main/resources/insuranceCards.txt") || !FileOperations.fileExists("src/main/resources/claims.txt") || !FileOperations.fileExists("src/main/resources/customers.txt")) {
            SampleFileGenerator.generateSampleFile();
        }
        RecordManager rm = new RecordManager<>();
        Program program = new Program(rm);
        program.start();
    }
}
