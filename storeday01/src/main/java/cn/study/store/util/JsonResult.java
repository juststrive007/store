package cn.study.store.util;

import lombok.Data;

/**
 * 用于封装返回给客户端的响应类型
 * @param <T>
 */
@Data
public class JsonResult<T> {
    private Integer state;
    private String message;
    private T data;

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult() {
    }

    public JsonResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }
}
