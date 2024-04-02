package Database;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

import Customer.Customer;

import java.util.Random;

/**
 * Interface for objects that can be recorded.
 *
 * <p>
 * Provides methods for generating and managing unique IDs.
 * </p>
 *
 * <p>
 * This interface includes a default method to generate IDs based on the implementing class.
 * </p>
 *
 * <p>
 * Note: Implementing classes should provide their own implementation for the getID and setID methods.
 * </p>
 *
 * <p>
 * Note: The ID generation method uses a Random object for generating random numbers.
 * </p>
 */
public interface Recordable {
    /**
     * Random object for generating random numbers.
     */
    Random RANDOM_ID_GENERATOR = new Random();

    /**
     * Generates a unique ID based on the implementing class.
     *
     * @return A unique ID as a string.
     */
    default String generateID() {
        if (this instanceof Customer) {
            int randomNumber = RANDOM_ID_GENERATOR.nextInt(1, 10000001);
            return String.format("%07d", randomNumber);
        } else {
            int randomNumber = RANDOM_ID_GENERATOR.nextInt(1, 1000000001);
            return String.format("%09d", randomNumber);
        }
    }

    /**
     * Gets the ID of the object.
     *
     * @return The ID of the object.
     */
    String getID();

    /**
     * Sets a unique ID for the object.
     *
     * @return The generated ID as a string.
     */
    String setID();
}

