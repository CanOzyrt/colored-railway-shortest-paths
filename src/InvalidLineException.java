public class InvalidLineException extends RuntimeException {
  public InvalidLineException(String errorMessage) {
    super(errorMessage);
  }
  public InvalidLineException(String errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }
}
