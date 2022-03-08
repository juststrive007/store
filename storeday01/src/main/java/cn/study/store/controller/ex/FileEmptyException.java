package cn.study.store.controller.ex;

/**
 * 文件为空异常
 * @author wm
 */
public class FileEmptyException extends FileUploadException{
    private static final long serialVersionUID = -5203457098428324949L;

    public FileEmptyException() {
    }

    public FileEmptyException(String message) {
        super(message);
    }

    public FileEmptyException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileEmptyException(Throwable cause) {
        super(cause);
    }

    public FileEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
