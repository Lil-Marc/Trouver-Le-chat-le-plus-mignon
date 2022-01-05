package com.cat.error;

/**
 * Created by Marc on 2022/1/05.
 */
public enum EmBusinessError implements CommonError {
    //Generic error type 10000x
    PARAMETER_VALIDATION_ERROR(10001,"Parameter not legal"),
    UNKNOWN_ERROR(10002,"Unknown error"),

    //User information related error definition 20000x
    CAT_NOT_EXIST(20001,"This cat does not exist"),
    VOTE_CAT_FAILED(20002,"Vote cat failed pls try again")
    ;

    EmBusinessError(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }


    private int errCode;
    private String errMsg;


    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
