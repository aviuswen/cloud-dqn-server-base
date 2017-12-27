package cloud.dqn.models;

public class ExceptionResponse extends ErrorResponse {
    private Exception exception;
    public ExceptionResponse() {
        this(null);
    }

    public ExceptionResponse(Exception exception) {
        super();
        if (exception != null) {
            this.error = exception.toString();
        }
        this.exception = exception;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
        if (exception == null) {
            this.error = null;
        } else {
            this.error = exception.toString();
        }
    }
    public void setException(String error, Exception exception) {
        this.exception = exception;
        this.error = error;
    }
}
