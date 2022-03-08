package cn.study.store.controller.ex;

/**
 * 上传文件时，文件状态异常，可能是因为文件被移动，到时文件不可访问
 * @author wm
 */
public class FileStateException extends FileUploadException{
    private static final long serialVersionUID = -3292682148594840337L;

    public FileStateException() {
    }

    public FileStateException(String message) {
        super(message);
    }

    public FileStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileStateException(Throwable cause) {
        super(cause);
    }

    public FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
