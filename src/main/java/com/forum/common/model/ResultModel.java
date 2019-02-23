package com.forum.common.model;

import com.forum.common.constant.ErrorCodeEnum;

import java.io.Serializable;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class ResultModel<T> implements Serializable {

    private static final long serialVersionUID = -4543275557806970503L;

    /**
     * 状态码 0成功，其他失败
     */
    private int code;

    /**
     * 返回码对应描述
     */
    private String message;

    /**
     * 有效数据负载
     */
    private T data;

    protected ResultModel(T data) {
        this(data, ErrorCodeEnum.OK);
    }

    protected ResultModel(T data, ErrorCodeEnum code) {
        super();
        this.code = code.getCode();
        this.message = code.getMessage();
        this.data = data;
    }

    protected ResultModel(int code, String message, T data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    private void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    private void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    private void setData(T data) {
        this.data = data;
    }

    public void setCodeEnum(T data) {
        setCodeEnum(ErrorCodeEnum.OK, data);
    }

    public void setCodeEnum(ErrorCodeEnum errorCodeEnum) {
        setCodeEnum(errorCodeEnum, getData());
    }

    private void setCodeEnum(ErrorCodeEnum errorCodeEnum, T data) {
        setMessage(errorCodeEnum.getMessage());
        setCode(errorCodeEnum.getCode());
        setData(data);
    }

    /**
     * 返回错误结果
     * @param code 状态码
     * @param msg 错误信息
     * @return 靳旺
     */
    public static ResultModel getErrorResultModel(int code,String msg){
        return  new ResultModel(code,msg,null);
    }

    /**
     * 返回错误枚举结果
     * @param errorCodeEnum  枚举状态码
     * @param message 信息描述
     * @return 靳旺
     */
    public static ResultModel getErrorResultModel(ErrorCodeEnum errorCodeEnum,String message){
        return new ResultModel(errorCodeEnum.getCode(),message,null);
    }

    /**
     * 获取一个错误的返回结果
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return 靳旺
     */
    public static <T> ResultModel<T> getErrorResultModel(int code,String msg,T data){
        return new ResultModel(code,msg,data);
    }

    /**
     * 获取一个错误的返回结果
     * @param msg
     * @return 靳旺
     */
    public static ResultModel getErrorResultModel(String msg){
        return new ResultModel(ErrorCodeEnum.FAILED.getCode(),msg,null);
    }

    /**
     * 获取一个错误的返回结果
     * @return 靳旺
     */
    public static ResultModel getErrorResultModel(){
        return new ResultModel(null,ErrorCodeEnum.FAILED);
    }

    /**
     * 获取一个错误的返回结果
     *
     * @param errorCodeEnum
     * @return  靳旺
     */
    public static ResultModel getErrorResultModel(ErrorCodeEnum errorCodeEnum){
        return  new ResultModel(errorCodeEnum.getCode(),errorCodeEnum.getMessage(),null);
    }


    /**
     * 获取一个成功的返回结果
     *
     * @return 靳旺
     */
    public static ResultModel getSuccessResultModel(){
        return new ResultModel(ErrorCodeEnum.OK.getCode(),ErrorCodeEnum.OK.getMessage(),null);
    }

    /**
     * 获取成功的返回结果
     * @param errorCodeEnum
     * @return 靳旺
     */
    public static ResultModel getSuccessResultModel(ErrorCodeEnum errorCodeEnum){
        return new ResultModel(errorCodeEnum.getCode(),errorCodeEnum.getMessage(),null);
    }

    /**
     * 获取成功的返回结果
     * @param errorCodeEnum
     * @param data
     * @param <T>
     * @return 靳旺
     */
    public static <T> ResultModel<T> getSuccessResultModel(ErrorCodeEnum errorCodeEnum, T data){
        return new ResultModel(errorCodeEnum.getCode(),errorCodeEnum.getMessage(),data);
    }

    /**
     * 获取成功的返回结果
     *
     * @param data
     *
     * @return 靳旺
     */
    public static <T> ResultModel<T> getSuccessResultModel(Object data){
        return new ResultModel(ErrorCodeEnum.OK.getCode(),ErrorCodeEnum.OK.getMessage(),data);
    }

    /**
     * 获取成功的返回结果
     * @param code
     * @param msg
     * @param <T>
     * @return  靳旺
     */
    public static <T> ResultModel <T> getSuccessResultModel(int code,String msg){
        return new ResultModel(code,msg,null);
    }

    /**
     * 获取成功的返回结果
     * @param msg
     * @param <T>
     * @return  靳旺
     */
    public static <T> ResultModel<T> getSuccessResultModel(String msg) {
        return new ResultModel(ErrorCodeEnum.OK.getCode(), msg, null);
    }

    /**
     * 获取成功的返回结果
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return  靳旺
     */
    public static <T> ResultModel<T> getSuccessResultModel(int code, String msg, T data) {
        return new ResultModel(code, msg, data);
    }
}
