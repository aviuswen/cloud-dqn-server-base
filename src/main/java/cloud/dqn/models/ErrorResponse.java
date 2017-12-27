package cloud.dqn.models;

public class ErrorResponse {
    protected String error;

    public ErrorResponse() {
        this(null);
    }

    public ErrorResponse(String error) {
        this.error = error;
    }

    public boolean success() {
        return error == null;
    }

    public boolean failure() {
        return error != null;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        if (error != null) {
            return error;
        }
        return MISSING_ERROR;
    }

    public static final String MISSING_ERROR = "no error set";
}
