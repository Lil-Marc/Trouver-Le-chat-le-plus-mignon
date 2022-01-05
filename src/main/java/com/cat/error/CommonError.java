package com.cat.error;

/**
 * Created by Marc on 2022/1/05.
 */
public interface CommonError {
    public int getErrCode();
    public String getErrMsg();
    public CommonError setErrMsg(String errMsg);
}
