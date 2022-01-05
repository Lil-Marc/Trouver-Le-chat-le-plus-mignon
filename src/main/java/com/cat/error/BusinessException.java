package com.cat.error;

/**
 * Created by Marc on 2022/1/05.
 */
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    //Receive EmBusinessError pass-throughs directly for constructing business exceptions
    public BusinessException(CommonError commonError){
        super();
        this.commonError = commonError;
    }

    //Construct business exceptions by receiving custom errMsg
    public BusinessException(CommonError commonError,String errMsg){
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }




    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }

    public CommonError getCommonError() {
        return commonError;
    }
}
