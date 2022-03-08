package cn.study.store.controller.ex;

/**
 * 文件大小异常
 * @author wm
 */
public class FileSizeException extends FileUploadException {
    private static final long serialVersionUID = 2678225773431724824L;

    public FileSizeException() {
    }

    public FileSizeException(String message) {
        super(message);
    }

    public FileSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSizeException(Throwable cause) {
        super(cause);
    }

    public FileSizeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
