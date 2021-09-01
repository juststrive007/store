package cn.study.store.service.ex;

/**
 * 用户名冲突异常
 *
 * @author wm
 */
public class PasswordNotMatchException extends ServiceException {

    private static final long serialVersionUID = 1894749589419465801L;

    public PasswordNotMatchException() {
    }

    public PasswordNotMatchException(String message) {
        super(message);
    }

    public PasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    public PasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
