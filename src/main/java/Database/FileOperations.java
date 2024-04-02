package Database;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import java.io.*;
import java.util.List;

/**
 * Provides file operations for reading and writing objects to files.
 *
 * <p>
 * This class includes methods for reading objects from files,
 * writing objects to files, and checking if a file exists.
 * </p>
 *
 * <p>
 * Serialization is used for reading and writing objects.
 * </p>
 *
 * <p>
 * Note: This class is not meant to be instantiated.
 * All methods are static.
 * </p>
 */
public class FileOperations implements Serializable {

    /**
     * Reads objects from a file and returns an ObjectInputStream.
     *
     * @param FILE_NAME The name of the file to read from.
     * @return An ObjectInputStream for reading objects from the file.
     * @throws RuntimeException if an IO error occurs during reading.
     */
    public static ObjectInputStream read(String FILE_NAME) {
        try  {
            return new ObjectInputStream(new FileInputStream(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes a list of items to a file.
     *
     * @param item The list of items to write.
     * @param FILE_NAME The name of the file to write to.
     * @throws RuntimeException if an IO error occurs during writing.
     */
    public static void write(List<?> item, String FILE_NAME) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

            try (FileOutputStream fos = new FileOutputStream(file)) {
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Checks if a file exists.
     *
     * @param FILE_NAME The name of the file to check.
     * @return true if the file exists, false otherwise.
     */
    public static boolean fileExists(String FILE_NAME) {
        File file = new File(FILE_NAME);
        return file.exists();
    }
}