package com.kent.scheduler.admin.common.api;

/**
 * @author kent on 2017/10/5.
 */
public final class ApiResult<T> {

    public static final boolean SUCCESS = true;
    public static final boolean FAILED = false;

    public static final int DEFAULT_SUCCESS_CODE = 0;
    public static final int DEFAULT_FAILED_CODE = 1;

    public static final String DEFAULT_SUCCESS_MSG = "成功";
    public static final String DEFAULT_FAILED_MSG = "失败";

    private boolean succ;
    private int code;
    private String msg;
    private T data;

    public static <T> ApiResult<T> succ() {
        return succ(DEFAULT_SUCCESS_MSG, null);
    }

    public static <T> ApiResult<T> succ(T data) {
        return succ(DEFAULT_SUCCESS_MSG, data);
    }

    public static <T> ApiResult<T> succ(String msg, T data) {
        return create(SUCCESS, DEFAULT_SUCCESS_CODE, msg, data);
    }


    public static <T> ApiResult<T> fail() {
        return fail(DEFAULT_FAILED_MSG);
    }

    public static <T> ApiResult<T> fail(String msg) {
        return fail(msg, null);
    }

    public static <T> ApiResult<T> fail(T data) {
        return fail(DEFAULT_FAILED_MSG, data);
    }

    public static <T> ApiResult<T> fail(String msg, T data) {
        return fail(DEFAULT_FAILED_CODE, msg, data);
    }

    public static <T> ApiResult<T> fail(int code, String msg) {
        return fail(code, msg, null);
    }

    public static <T> ApiResult<T> fail(int code, String msg, T data) {
        return create(FAILED, code, msg, data);
    }


    public static <T> ApiResult<T> create(boolean succ, int code, String msg, T data) {
        return new ApiResult<>(succ, code, msg, data);
    }


    private ApiResult(boolean succ, int code, String msg, T data) {
        this.succ = succ;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public boolean isSucc() {
        return succ;
    }

    public void setSucc(boolean succ) {
        this.succ = succ;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
