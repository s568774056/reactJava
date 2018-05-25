package routine.domain;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Author:   ssp
 * Date:     2018/5/24 18:40
 * desc       描述
 */
public class Application {

    public String dpAppNo;//申请序号 [YYYYMMDDNNNNN   YYYYMMDD：申请日   NNNNN：每天从00001开始的序号]
    public String appWxOpenId;//申请者微信OPEN ID
    @NotBlank(message = "姓名必传")
    public String mBrName;//被保险人姓名
    @NotBlank(message = "身份证号必传")
    public String mBrIdCardNo;//被保险人身份证号
    @NotBlank(message = "医院名称必传")
    public String hospName;//住院医院名称
    @NotBlank(message = "入院日期必传")
    public String inHospDate;//入院日期  [YYYYMMDD]
    @NotBlank(message = "申请日期必传")
    public String dpAppDate;//申请日期   [YYYYMMDD]

    public String provOid;//住院医院OID
    public String flowStatus;//流程状态   [FL_STAT_001:申请审核中     FL_STAT_002:申请审核通过（住院号未提交）
                                            // FL_STAT_003:申请审核通过  FL_STAT_004:申请审核不通过
                                            //FL_STAT_005:住院过程审核中 FL_STAT_006:住院过程审核不通过
                                            //FL_STAT_007:预结算         FL_STAT_008:已结算]
    public String claimStatus;//案件状态 [CL_STAT_000:处理中 CL_STAT_001:结束  备注:记录]
    public String crtUser;//创建者
    public String crtDate;//创建时间  [精确至秒]
    public String updUser;//更新者
    public String updDate;//更新时间  [精确至秒]
    //以上均不能为空
    public String inHospNo;//住院号
    public String appAuditorId;//申请审核者
    public String processAuditorId;//过程审核者
    public String rejectReason;//审核不通过原因
    public String hospAgent1WxOpenId;//驻院代表1微信OPEN ID
    public String hospAgent2WxOpenId;//驻院代表2微信OPEN ID
    public String hospAgent3WxOpenId;//驻院代表3微信OPEN ID
    public String clNo;//理赔案件NO
    public String buffer1;//备用1
    public String buffer2;//
    public String buffer3;//
    public String buffer4;//
    public String buffer5;//

    public String getDpAppNo() {
        return dpAppNo;
    }

    public void setDpAppNo(String dpAppNo) {
        this.dpAppNo = dpAppNo;
    }

    public String getAppWxOpenId() {
        return appWxOpenId;
    }

    public void setAppWxOpenId(String appWxOpenId) {
        this.appWxOpenId = appWxOpenId;
    }

    public String getmBrName() {
        return mBrName;
    }

    public void setmBrName(String mBrName) {
        this.mBrName = mBrName;
    }

    public String getmBrIdCardNo() {
        return mBrIdCardNo;
    }

    public void setmBrIdCardNo(String mBrIdCardNo) {
        this.mBrIdCardNo = mBrIdCardNo;
    }

    public String getHospName() {
        return hospName;
    }

    public void setHospName(String hospName) {
        this.hospName = hospName;
    }

    public String getInHospDate() {
        return inHospDate;
    }

    public void setInHospDate(String inHospDate) {
        this.inHospDate = inHospDate;
    }

    public String getDpAppDate() {
        return dpAppDate;
    }

    public void setDpAppDate(String dpAppDate) {
        this.dpAppDate = dpAppDate;
    }

    public String getProvOid() {
        return provOid;
    }

    public void setProvOid(String provOid) {
        this.provOid = provOid;
    }

    public String getFlowStatus() {
        return flowStatus;
    }

    public void setFlowStatus(String flowStatus) {
        this.flowStatus = flowStatus;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    public String getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(String crtDate) {
        this.crtDate = crtDate;
    }

    public String getUpdUser() {
        return updUser;
    }

    public void setUpdUser(String updUser) {
        this.updUser = updUser;
    }

    public String getUpdDate() {
        return updDate;
    }

    public void setUpdDate(String updDate) {
        this.updDate = updDate;
    }

    public String getInHospNo() {
        return inHospNo;
    }

    public void setInHospNo(String inHospNo) {
        this.inHospNo = inHospNo;
    }

    public String getAppAuditorId() {
        return appAuditorId;
    }

    public void setAppAuditorId(String appAuditorId) {
        this.appAuditorId = appAuditorId;
    }

    public String getProcessAuditorId() {
        return processAuditorId;
    }

    public void setProcessAuditorId(String processAuditorId) {
        this.processAuditorId = processAuditorId;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public String getHospAgent1WxOpenId() {
        return hospAgent1WxOpenId;
    }

    public void setHospAgent1WxOpenId(String hospAgent1WxOpenId) {
        this.hospAgent1WxOpenId = hospAgent1WxOpenId;
    }

    public String getHospAgent2WxOpenId() {
        return hospAgent2WxOpenId;
    }

    public void setHospAgent2WxOpenId(String hospAgent2WxOpenId) {
        this.hospAgent2WxOpenId = hospAgent2WxOpenId;
    }

    public String getHospAgent3WxOpenId() {
        return hospAgent3WxOpenId;
    }

    public void setHospAgent3WxOpenId(String hospAgent3WxOpenId) {
        this.hospAgent3WxOpenId = hospAgent3WxOpenId;
    }

    public String getClNo() {
        return clNo;
    }

    public void setClNo(String clNo) {
        this.clNo = clNo;
    }

    public String getBuffer1() {
        return buffer1;
    }

    public void setBuffer1(String buffer1) {
        this.buffer1 = buffer1;
    }

    public String getBuffer2() {
        return buffer2;
    }

    public void setBuffer2(String buffer2) {
        this.buffer2 = buffer2;
    }

    public String getBuffer3() {
        return buffer3;
    }

    public void setBuffer3(String buffer3) {
        this.buffer3 = buffer3;
    }

    public String getBuffer4() {
        return buffer4;
    }

    public void setBuffer4(String buffer4) {
        this.buffer4 = buffer4;
    }

    public String getBuffer5() {
        return buffer5;
    }

    public void setBuffer5(String buffer5) {
        this.buffer5 = buffer5;
    }
}
