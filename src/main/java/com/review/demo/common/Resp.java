package com.review.demo.common;

/**
 * 封装返回值
 */
public class Resp<T> {
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回信息
     */
    private T data;

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

    public Resp() {
    }

    public Resp(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //返回结果
    public Resp setReslut(T data) {
        Resp resp = new Resp();
        resp.setCode(this.code);
        resp.setMsg(this.msg);
        resp.setData(data);
        return resp;
    }

//    //失败后返回错误原因
//    public Resp setReson(String errorDetail) {
//        Resp resp = new Resp();
//        resp.setData(errorDetail);
//        resp.setCode(this.code);
//        resp.setMsg(this.msg);
//        return resp;
//    }

    //操作成功
    public static final Resp SUCCESS = new Resp(0, "操作成功");
    //操作失败
    public static final Resp Fail = new Resp(1, "操作失败");
}
