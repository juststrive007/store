package cn.study.store.controller;

import cn.study.store.controller.ex.*;
import cn.study.store.service.ex.*;
import cn.study.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制器基类
 */

public abstract class BaseController {
    /**
     * 操作成功状态码
     */
    public static final int OK = 2000;

    /**
     * service 异常处理
     *
     * @param e 框架捕获的异常
     * @return JsonResult
     */
    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> jsonResult = new JsonResult<Void>(e);
        if (e instanceof UsernameDuplicatedException) {
            jsonResult.setState(4000);
        } else if (e instanceof UserNotFoundException) {
            jsonResult.setState(4002);
        } else if (e instanceof PasswordNotMatchException) {
            jsonResult.setState(4003);
        } else if (e instanceof InsertException) {
            jsonResult.setState(5000);
        } else if (e instanceof UpdateException) {
            jsonResult.setState(5001);
        } else if (e instanceof FileEmptyException) {
            jsonResult.setState(6001);
        } else if (e instanceof FileIoException) {
            jsonResult.setState(6002);
        } else if (e instanceof FileSizeException) {
            jsonResult.setState(6003);
        } else if (e instanceof FileStateException) {
            jsonResult.setState(6004);
        } else if (e instanceof FileTypeException) {
            jsonResult.setState(6005);
        }
        return jsonResult;
    }
}
