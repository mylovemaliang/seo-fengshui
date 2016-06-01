//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.fuyoushuo.fengshui.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class HttpJsonResult implements Serializable {
    private static final long serialVersionUID = -1684032359202665547L;
    private Integer s = Integer.valueOf(0);
    private String m = "";
    private Object r = "";

    public HttpJsonResult(boolean success, String message, Object returnObject) {
        if(success) {
            this.s = Integer.valueOf(1);
        }

        if(StringUtils.isNotBlank(message)) {
            this.m = message;
        }

        if(returnObject != null) {
            this.r = returnObject;
        }

    }

    public static HttpJsonResult ofErrorResult(String errorMessage) {
        return new HttpJsonResult(false, errorMessage, (Object)null);
    }

    public static HttpJsonResult ofSuccessResult(String successMessage, Object returnObject) {
        return new HttpJsonResult(true, successMessage, returnObject);
    }

    public static HttpJsonResult ofSuccessResult(Object returnObject) {
        return new HttpJsonResult(true, (String)null, returnObject);
    }

    public Integer getS() {
        return this.s;
    }

    public void setS(Integer s) {
        this.s = s;
    }

    public String getM() {
        return this.m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public Object getR() {
        return this.r;
    }

    public void setR(Object r) {
        this.r = r;
    }
}
