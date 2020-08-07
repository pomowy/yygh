package com.yuanqi.hc.info.virtualcard;

import java.io.Serializable;

/**
 * @author wy
 * @create 2020-06-15 15:47
 */
public class SignVirtualCardOutInfo  implements Serializable {

    private int Rc;
    private String ErrorMsg;
    private String VirtualCardNum;
    private String QrCode;
    private String ImgStr;

    public int getRc()
    {
        return this.Rc;
    }
    public void setRc(int rc) {
        this.Rc = rc;
    }
    public String getErrorMsg() {
        return this.ErrorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.ErrorMsg = errorMsg;
    }
    public String getVirtualCardNum() {
        return this.VirtualCardNum;
    }
    public void setVirtualCardNum(String virtualCardNum) {
        this.VirtualCardNum = virtualCardNum;
    }
    public String getQrCode() {
        return this.QrCode;
    }
    public void setQrCode(String qrCode) {
        this.QrCode = qrCode;
    }
    public String getImgStr() {
        return this.ImgStr;
    }
    public void setImgStr(String imgStr) {
        this.ImgStr = imgStr;
    }

    public SignVirtualCardOutInfo(int rc, String errorMsg) {
        this.Rc = rc;
        this.ErrorMsg = errorMsg;
    }

    public SignVirtualCardOutInfo()
    {
    }

    public SignVirtualCardOutInfo(int rc, String errorMsg, String virtualCardNum, String qrCode, String imgStr)
    {
        this.Rc = rc;
        this.ErrorMsg = errorMsg;
        this.VirtualCardNum = virtualCardNum;
        this.QrCode = qrCode;
        this.ImgStr = imgStr;
    }

    public String toString() {
        return "SignVirtualCardOutInfo [Rc=" + this.Rc + ", ErrorMsg=" + this.ErrorMsg + ", VirtualCardNum=" + this.VirtualCardNum + ", QrCode=" + this.QrCode + ", ImgStr=" + this.ImgStr + "]";
    }
}
