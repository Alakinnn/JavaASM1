package Claim;
/**
 * @author <Duong Tran Minh Hoang - S3978452>
 */


/**
 * Enumeration representing the status of a claim.
 * Possible values are NEW, PROCESSING, and DONE.
 */
public enum Status {
    /**
     * Indicates that the claim is new and has not been processed yet.
     */
    NEW,

    /**
     * Indicates that the claim is currently being processed.
     */
    PROCESSING,

    /**
     * Indicates that the claim processing is done.
     */
    DONE
}
