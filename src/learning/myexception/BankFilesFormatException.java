package learning.myexception;

/**
 * @description
 * @author:Gjc
 * @time: 14:13
 * @date: 2022-03-03
 */


public class BankFilesFormatException extends RuntimeException{
    public BankFilesFormatException() {
        super();
    }

    public BankFilesFormatException(String message) {
        super(message);
    }

    public BankFilesFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankFilesFormatException(Throwable cause) {
        super(cause);
    }

    protected BankFilesFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
