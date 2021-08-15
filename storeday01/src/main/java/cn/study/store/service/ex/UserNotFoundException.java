package cn.study.store.service.ex;

/**
 * 用户名冲突异常
 *
 * @author wm
 */
public class UserNotFoundException extends ServiceException{

    private static final long serialVersionUID = 7096322544364858703L;

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
