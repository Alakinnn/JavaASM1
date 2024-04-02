import Datebase.FileOperations;
import Datebase.RecordManager;
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
