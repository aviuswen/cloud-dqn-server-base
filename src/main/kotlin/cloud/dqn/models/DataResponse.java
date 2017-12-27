package cloud.dqn.models;

public class DataResponse<T> extends ErrorResponse {
    public T data;

    public DataResponse() {
        this(null, null);
    }

    public DataResponse(T data) {
        this(data, null);
    }

    public DataResponse(T data, String error) {
        super(error);
        this.data = data;
    }
}
