package displaylist.collectionbdclient.utils;

/**
 * Created by b.bassac on 17/12/2014.
 */
public class CustomException extends Exception {

    public CustomException(){
    }

    /**
     * Constructs a new {@code IOException} with its stack trace and detail
     * message filled in.
     *
     * @param detailMessage
     *            the detail message for this exception.
     */
    public CustomException(String detailMessage){
        super(detailMessage);
    }

    /**
     * Constructs a new instance of this class with detail message and cause
     * filled in.
     *
     * @param message
     *            The detail message for the exception.
     * @param cause
     *            The detail cause for the exception.
     * @since 1.6
     */
    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new instance of this class with its detail cause filled in.
     *
     * @param cause
     *            The detail cause for the exception.
     * @since 1.6
     */
    public CustomException(Throwable cause) {
        super(cause == null ? null : cause.toString(), cause);
    }
}
