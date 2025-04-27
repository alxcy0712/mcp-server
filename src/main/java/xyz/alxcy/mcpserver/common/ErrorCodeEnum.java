package xyz.alxcy.mcpserver.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    /**
     * 成功
     */
    SUCCESS(ErrorCode.SUCCESS, "成功"),
    /**
     * 一般性错误
     */
    GENERAL_ERROR(ErrorCode.GENERAL_ERROR, "一般性错误"),
    ;
    private final Integer code;
    private final String errorMessage;
}
