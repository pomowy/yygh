package com.yuanqi.hc.info.virtualcard;

import java.io.Serializable;

/**
 * @author wy
 * @create 2020-06-15 15:46
 */
public class SignVirtualCardInInfo   implements Serializable {

    private String RequestId;
    private String HospitaId;
    private String CardType;
    private String CardNo;
    private String Name;
    private String Birthday;
    private String Address;
    private String Sex;
    private String Mobile;
    private String Nation;
    private String Operator;
    private String SignMode;
    private String extInfo;

    public String getExtInfo()
    {
        return this.extInfo;
    }

    public void setExtInfo(String extInfo) {
        this.extInfo = extInfo;
    }

    public String getSignMode()
    {
        return this.SignMode;
    }
    public void setSignMode(String signMode) {
        this.SignMode = signMode;
    }
    public String getRequestId() {
        return this.RequestId;
    }
    public void setRequestId(String requestId) {
        this.RequestId = requestId;
    }
    public String getHospitaId() {
        return this.HospitaId;
    }
    public void setHospitaId(String hospitaId) {
        this.HospitaId = hospitaId;
    }
    public String getCardType() {
        return this.CardType;
    }
    public void setCardType(String cardType) {
        this.CardType = cardType;
    }
    public String getCardNo() {
        return this.CardNo;
    }
    public void setCardNo(String cardNo) {
        this.CardNo = cardNo;
    }
    public String getName() {
        return this.Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public String getBirthday() {
        return this.Birthday;
    }
    public void setBirthday(String birthday) {
        this.Birthday = birthday;
    }
    public String getAddress() {
        return this.Address;
    }
    public void setAddress(String address) {
        this.Address = address;
    }
    public String getSex() {
        return this.Sex;
    }
    public void setSex(String sex) {
        this.Sex = sex;
    }
    public String getMobile() {
        return this.Mobile;
    }
    public void setMobile(String mobile) {
        this.Mobile = mobile;
    }
    public String getOperator() {
        return this.Operator;
    }
    public void setOperator(String operator) {
        this.Operator = operator;
    }
    public String getNation() {
        return this.Nation;
    }
    public void setNation(String nation) {
        this.Nation = nation;
    }

    public String toString() {
        return "SignVirtualCardInInfo [CardType=" + this.CardType + ", CardNo=" + this.CardNo + ", Name=" + this.Name + ", Birthday=" + this.Birthday + ", Address=" + this.Address + ", Sex=" + this.Sex + ", Mobile=" + this.Mobile + ", Nation=" + this.Nation + ", Operator=" + this.Operator + "]";
    }
}
