package com.cat.response;

public class CommonReturnType {
    //Indicates the return processing result "success" or "fail" for the corresponding request
    private String status;

    //If status=success, the data will return the json data needed for the front-end
    //If status=fail, then the generic error code format is used within data
    private Object data;

    //Define a generic creation method
    public static CommonReturnType create(Object result){
        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result,String status){
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
