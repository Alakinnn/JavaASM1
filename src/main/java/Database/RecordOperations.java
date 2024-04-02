package Database;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */

/**
 * Interface for database record operations.
 *
 * <p>
 * This interface defines methods for adding, deleting, finding, updating, and adding records to a database.
 * </p>
 *
 * <p>
 * Note: Implementing classes should provide their own implementations for these methods.
 * </p>
 *
 * @param <T> The type of record to be operated on.
 */
public interface RecordOperations<T extends Recordable> {
    /**
     * Adds a record to the database.
     *
     * @param record The record to be added.
     */
    void add(T record);

    /**
     * Deletes a record from the database based on its ID.
     *
     * @param id The ID of the record to be deleted.
     */
    void delete(String id);

    /**
     * Finds a record in the database based on its ID.
     *
     * @param id The ID of the record to find.
     * @return The found record, or null if not found.
     */
    T find(String id);

    /**
     * Adds records to the database.
     *
     * @param record The record to be added.
     */
    void addRecords(T record);

    /**
     * Updates records in the database.
     *
     * @param record The updated record.
     */
    void updateRecords(T record);
}
