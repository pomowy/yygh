package com.wy;

public class Doctors {
    private String  HOSPITALID ;
    private String  DEPTCODE ;
    private String  DOCTORNO ;
    private String  INPUTCODE ;
    private String  DOCTORNAME ;
    private String DOCTOR_TITLE;
    private String  SPECIALTY;			//	专长
    private String SPINPUTCODE	;	    //专长拼音输入码
    private String SMALLPHOTOURL;		//	小图
    private String MIDDLELPHOTOURL;	    //	中图
    private String BIGPHOTOURL	;		//	大图
    private String DOCTORDES	;		//医生简介
    private String DOCTORSEX	;		//性别1:男,2:女
    private String DOCTORMOTTO;		//行医座右铭
    private String LOCATION	;		//位置
    private int ISUSED		;	   //是否启用默认0：启用 1：禁用
    private String CREATEDATE;	  //	创建时间
    private String CREATOR	;	  //	创建者
    private String LASTMODIFY	;	//	修改时间
    private String LASTMODIFIER;		//		修改者
    private String HISDOCTORNO;		//		his同步医生代码
    private int ISDELETE;	//	删除标识
    private int ORDERNUM;
    private String  HISDEPTCODE;		//		his deptcode
    private String DOCTOROUTPTYPENAME	;	//		医生号别名称
    private String PARENTID;
    private String APPLYTYPE;	//	Y

    public Doctors() {
    }

    public String getHOSPITALID() {
        return HOSPITALID;
    }

    public void setHOSPITALID(String HOSPITALID) {
        this.HOSPITALID = HOSPITALID;
    }

    public String getDEPTCODE() {
        return DEPTCODE;
    }

    public void setDEPTCODE(String DEPTCODE) {
        this.DEPTCODE = DEPTCODE;
    }

    public String getDOCTORNO() {
        return DOCTORNO;
    }

    public void setDOCTORNO(String DOCTORNO) {
        this.DOCTORNO = DOCTORNO;
    }

    public String getINPUTCODE() {
        return INPUTCODE;
    }

    public void setINPUTCODE(String INPUTCODE) {
        this.INPUTCODE = INPUTCODE;
    }

    public String getDOCTORNAME() {
        return DOCTORNAME;
    }

    public void setDOCTORNAME(String DOCTORNAME) {
        this.DOCTORNAME = DOCTORNAME;
    }

    public String getDOCTOR_TITLE() {
        return DOCTOR_TITLE;
    }

    public void setDOCTOR_TITLE(String DOCTOR_TITLE) {
        this.DOCTOR_TITLE = DOCTOR_TITLE;
    }

    public String getSPECIALTY() {
        return SPECIALTY;
    }

    public void setSPECIALTY(String SPECIALTY) {
        this.SPECIALTY = SPECIALTY;
    }

    public String getSPINPUTCODE() {
        return SPINPUTCODE;
    }

    public void setSPINPUTCODE(String SPINPUTCODE) {
        this.SPINPUTCODE = SPINPUTCODE;
    }

    public String getSMALLPHOTOURL() {
        return SMALLPHOTOURL;
    }

    public void setSMALLPHOTOURL(String SMALLPHOTOURL) {
        this.SMALLPHOTOURL = SMALLPHOTOURL;
    }

    public String getMIDDLELPHOTOURL() {
        return MIDDLELPHOTOURL;
    }

    public void setMIDDLELPHOTOURL(String MIDDLELPHOTOURL) {
        this.MIDDLELPHOTOURL = MIDDLELPHOTOURL;
    }

    public String getBIGPHOTOURL() {
        return BIGPHOTOURL;
    }

    public void setBIGPHOTOURL(String BIGPHOTOURL) {
        this.BIGPHOTOURL = BIGPHOTOURL;
    }

    public String getDOCTORDES() {
        return DOCTORDES;
    }

    public void setDOCTORDES(String DOCTORDES) {
        this.DOCTORDES = DOCTORDES;
    }

    public String getDOCTORSEX() {
        return DOCTORSEX;
    }

    public void setDOCTORSEX(String DOCTORSEX) {
        this.DOCTORSEX = DOCTORSEX;
    }

    public String getDOCTORMOTTO() {
        return DOCTORMOTTO;
    }

    public void setDOCTORMOTTO(String DOCTORMOTTO) {
        this.DOCTORMOTTO = DOCTORMOTTO;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public int getISUSED() {
        return ISUSED;
    }

    public void setISUSED(int ISUSED) {
        this.ISUSED = ISUSED;
    }

    public String getCREATEDATE() {
        return CREATEDATE;
    }

    public void setCREATEDATE(String CREATEDATE) {
        this.CREATEDATE = CREATEDATE;
    }

    public String getCREATOR() {
        return CREATOR;
    }

    public void setCREATOR(String CREATOR) {
        this.CREATOR = CREATOR;
    }

    public String getLASTMODIFY() {
        return LASTMODIFY;
    }

    public void setLASTMODIFY(String LASTMODIFY) {
        this.LASTMODIFY = LASTMODIFY;
    }

    public String getLASTMODIFIER() {
        return LASTMODIFIER;
    }

    public void setLASTMODIFIER(String LASTMODIFIER) {
        this.LASTMODIFIER = LASTMODIFIER;
    }

    public String getHISDOCTORNO() {
        return HISDOCTORNO;
    }

    public void setHISDOCTORNO(String HISDOCTORNO) {
        this.HISDOCTORNO = HISDOCTORNO;
    }

    public int getISDELETE() {
        return ISDELETE;
    }

    public void setISDELETE(int ISDELETE) {
        this.ISDELETE = ISDELETE;
    }

    public int getORDERNUM() {
        return ORDERNUM;
    }

    public void setORDERNUM(int ORDERNUM) {
        this.ORDERNUM = ORDERNUM;
    }

    public String getHISDEPTCODE() {
        return HISDEPTCODE;
    }

    public void setHISDEPTCODE(String HISDEPTCODE) {
        this.HISDEPTCODE = HISDEPTCODE;
    }

    public String getDOCTOROUTPTYPENAME() {
        return DOCTOROUTPTYPENAME;
    }

    public void setDOCTOROUTPTYPENAME(String DOCTOROUTPTYPENAME) {
        this.DOCTOROUTPTYPENAME = DOCTOROUTPTYPENAME;
    }

    public String getPARENTID() {
        return PARENTID;
    }

    public void setPARENTID(String PARENTID) {
        this.PARENTID = PARENTID;
    }

    public String getAPPLYTYPE() {
        return APPLYTYPE;
    }

    public void setAPPLYTYPE(String APPLYTYPE) {
        this.APPLYTYPE = APPLYTYPE;
    }

    @Override
    public String toString() {
        return "Doctors{" + "HOSPITALID='" + HOSPITALID + '\'' + ", DEPTCODE='" + DEPTCODE + '\'' + ", DOCTORNO='" + DOCTORNO + '\'' + ", INPUTCODE='" + INPUTCODE + '\'' + ", DOCTORNAME='" + DOCTORNAME + '\'' + ", DOCTOR_TITLE='" + DOCTOR_TITLE + '\'' + ", SPECIALTY='" + SPECIALTY + '\'' + ", SPINPUTCODE='" + SPINPUTCODE + '\'' + ", SMALLPHOTOURL='" + SMALLPHOTOURL + '\'' + ", MIDDLELPHOTOURL='" + MIDDLELPHOTOURL + '\'' + ", BIGPHOTOURL='" + BIGPHOTOURL + '\'' + ", DOCTORDES='" + DOCTORDES + '\'' + ", DOCTORSEX='" + DOCTORSEX + '\'' + ", DOCTORMOTTO='" + DOCTORMOTTO + '\'' + ", LOCATION='" + LOCATION + '\'' + ", ISUSED=" + ISUSED + ", CREATEDATE='" + CREATEDATE + '\'' + ", CREATOR='" + CREATOR + '\'' + ", LASTMODIFY='" + LASTMODIFY + '\'' + ", LASTMODIFIER='" + LASTMODIFIER + '\'' + ", HISDOCTORNO='" + HISDOCTORNO + '\'' + ", ISDELETE=" + ISDELETE + ", ORDERNUM=" + ORDERNUM + ", HISDEPTCODE='" + HISDEPTCODE + '\'' + ", DOCTOROUTPTYPENAME='" + DOCTOROUTPTYPENAME + '\'' + ", PARENTID='" + PARENTID + '\'' + ", APPLYTYPE='" + APPLYTYPE + '\'' + '}';
    }
}
