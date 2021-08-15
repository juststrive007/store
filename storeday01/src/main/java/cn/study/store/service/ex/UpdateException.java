package cn.study.store.service.ex;

/**
 * 插入异常
 *
 * @author wm
 */
public class UpdateException extends ServiceException{
    private static final long serialVersionUID = -6204269438469685951L;

    public UpdateException() {
    }

    public UpdateException(String message) {
        super(message);
    }

    public UpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UpdateException(Throwable cause) {
        super(cause);
    }

    public UpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
