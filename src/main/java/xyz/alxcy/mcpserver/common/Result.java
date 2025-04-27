package xyz.alxcy.mcpserver.common;

public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(ErrorCode.SUCCESS, "success", data);
    }
    public static <T> Result<T> success() {
        return new Result<>(ErrorCode.SUCCESS, "success");
    }
    public static <T> Result<T> error(String message) {
        return new Result<>(ErrorCode.GENERAL_ERROR, message);
    }
    public static <T> Result<T> error(Integer errorCode, String errorMessage) {
        return new Result<>(errorCode, errorMessage);
    }
    public static <T> Result<T> error(ErrorCodeEnum errorCodeEnum) {
        return new Result<>(errorCodeEnum.getCode(), errorCodeEnum.getErrorMessage());
    }
}
