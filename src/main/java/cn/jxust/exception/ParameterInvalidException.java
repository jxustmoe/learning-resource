package cn.jxust.exception;

//参数验证异常
public class ParameterInvalidException extends Exception {
    public ParameterInvalidException(String message) {
        super(message);
    }
}
