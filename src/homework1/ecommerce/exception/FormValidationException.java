package homework1.ecommerce.exception;

public class FormValidationException extends RuntimeException {
  public FormValidationException(String message) {
    super(message);
  }
}
