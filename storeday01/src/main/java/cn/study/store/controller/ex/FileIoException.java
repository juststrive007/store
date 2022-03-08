package cn.study.store.controller.ex;

/**
 * 上传文件出现输入输出异常
 * @author wm
 */
public class FileIoException extends FileUploadException{
    private static final long serialVersionUID = 3831842850853509873L;

    public FileIoException() {
    }

    public FileIoException(String message) {
        super(message);
    }

    public FileIoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileIoException(Throwable cause) {
        super(cause);
    }

    public FileIoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
