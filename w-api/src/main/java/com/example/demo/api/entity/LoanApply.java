package com.example.demo.api.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author hhc
 * @since 2017-08-29
 */
@TableName("loan_apply")
public class LoanApply extends Model<LoanApply> {

    private static final long serialVersionUID = 1L;
    @TableId(type=IdType.UUID)
	private String id;
    /**
     * 车商id
     */
	@TableField("merchant_id")
	private String merchantId;
    /**
     * 保有客户id
     */
	@TableField("auto_user_id")
	private String autoUserId;

    /**
     * 车辆id
     */
	@TableField("car_id")
	private String carId;
    /**
     * 创建时间
     */
	@TableField("gmt_create")
	private Date gmtCreate;
    /**
     * 修改时间
     */
	@TableField("gmt_update")
	private Date gmtUpdate;
    /**
     * 申请状态(申请中，还款中，被拒绝，已取消等)
     */
	@TableField("apply_status")
	private String applyStatus;
    /**
     * 申请状态节点
     */
	@TableField("apply_task_key")
	private String applyTaskKey;
    /**
     * 申请结束时间
     */
	@TableField("gmt_apply_end")
	private Date gmtApplyEnd;
	private String memo;
    /**
     * 还款结束时间
     */
	@TableField("gmt_repayment_end")
	private Date gmtRepaymentEnd;
	@TableField("gmt_lended")
	private Date gmtLended;

	/**
     * 订单号
     */
	@TableField("loan_order_no")
	private String loanOrderNo;
	/**
	 * 资方放款
	 */
	@TableField("gmt_management_lended")
	private Date gmtManagementLended;
	/**
	 * 平台返款
	 */
	@TableField("gmt_platform_returns")
	private Date gmtPlatformReturns;
	
	/**
	 * 账户id
	 */
	@TableField("account_id")
	private String accountId;
	
	@TableField("child_id")
	private Integer childId;

	
	/**
     * 还款状态(待还款“pendingRepay”  已还款“repayments”  逾期“overdue”)
     */
	@TableField("repay_status")
	private String repayStatus;
    /**
     * 还款节点
     */
	@TableField("repay_task_key")
	private String repayTaskKey;
    /**
     * 当前应还期数
     */
	@TableField("repay_periods")
	private Integer repayPeriods;
	@TableField("is_delete")
	private Integer isDelete;

	public Integer getChildId() {
		return childId;
	}

	public void setChildId(Integer childId) {
		this.childId = childId;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getAutoUserId() {
		return autoUserId;
	}

	public void setAutoUserId(String autoUserId) {
		this.autoUserId = autoUserId;
	}

	public String getCarId() {
		return carId;
	}

	public void setCarId(String carId) {
		this.carId = carId;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtUpdate() {
		return gmtUpdate;
	}

	public void setGmtUpdate(Date gmtUpdate) {
		this.gmtUpdate = gmtUpdate;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public String getApplyTaskKey() {
		return applyTaskKey;
	}

	public void setApplyTaskKey(String applyTaskKey) {
		this.applyTaskKey = applyTaskKey;
	}

	public Date getGmtApplyEnd() {
		return gmtApplyEnd;
	}

	public void setGmtApplyEnd(Date gmtApplyEnd) {
		this.gmtApplyEnd = gmtApplyEnd;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getGmtRepaymentEnd() {
		return gmtRepaymentEnd;
	}

	public void setGmtRepaymentEnd(Date gmtRepaymentEnd) {
		this.gmtRepaymentEnd = gmtRepaymentEnd;
	}

	public Date getGmtLended() {
		return gmtLended;
	}

	public void setGmtLended(Date gmtLended) {
		this.gmtLended = gmtLended;
	}

	public String getLoanOrderNo() {
		return loanOrderNo;
	}

	public void setLoanOrderNo(String loanOrderNo) {
		this.loanOrderNo = loanOrderNo;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public Date getGmtManagementLended() {
		return gmtManagementLended;
	}

	public void setGmtManagementLended(Date gmtManagementLended) {
		this.gmtManagementLended = gmtManagementLended;
	}

	public Date getGmtPlatformReturns() {
		return gmtPlatformReturns;
	}

	public void setGmtPlatformReturns(Date gmtPlatformReturns) {
		this.gmtPlatformReturns = gmtPlatformReturns;
	}

	public String getRepayStatus() { return repayStatus; }

	public void setRepayStatus(String repayStatus) { this.repayStatus = repayStatus; }

	public String getRepayTaskKey() { return repayTaskKey; }

	public void setRepayTaskKey(String repayTaskKey) { this.repayTaskKey = repayTaskKey; }

	public Integer getRepayPeriods() { return repayPeriods; }

	public void setRepayPeriods(Integer repayPeriods) { this.repayPeriods = repayPeriods; }

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public String toString() {
		return "LoanApply{" +
				"id='" + id + '\'' +
				", merchantId='" + merchantId + '\'' +
				", autoUserId='" + autoUserId + '\'' +
				", carId='" + carId + '\'' +
				", gmtCreate=" + gmtCreate +
				", gmtUpdate=" + gmtUpdate +
				", applyStatus='" + applyStatus + '\'' +
				", applyTaskKey='" + applyTaskKey + '\'' +
				", gmtApplyEnd=" + gmtApplyEnd +
				", memo='" + memo + '\'' +
				", gmtRepaymentEnd=" + gmtRepaymentEnd +
				", gmtLended=" + gmtLended +
				", loanOrderNo='" + loanOrderNo + '\'' +
				", gmtManagementLended=" + gmtManagementLended +
				", gmtPlatformReturns=" + gmtPlatformReturns +
				", accountId='" + accountId + '\'' +
				", childId=" + childId +
				", repayStatus='" + repayStatus + '\'' +
				", repayTaskKey='" + repayTaskKey + '\'' +
				", repayPeriods=" + repayPeriods +
				'}';
	}
}
