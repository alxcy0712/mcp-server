package xyz.alxcy.mcpserver.common;

/**
 * 服务异常
 */
public class ServiceException extends RuntimeException{

    private Integer code;
    private String errorMessage;

    public ServiceException(String errorMessage){
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public ServiceException(Integer code, String errorMessage){
        super(errorMessage);
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public ServiceException(ErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getErrorMessage());
        this.code = errorCodeEnum.getCode();
        this.errorMessage = errorCodeEnum.getErrorMessage();
    }

    public Integer getCode() {
        return code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
