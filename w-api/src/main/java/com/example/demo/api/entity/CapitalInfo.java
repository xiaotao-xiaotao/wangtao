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
 * @author 3
 * @since 2017-12-08
 */
@TableName("capital_info")
public class CapitalInfo extends Model<CapitalInfo> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.UUID)
	private String id;
    /**
     * 产品类型中(车商贷:csd，消费贷:cld)
     */
	@TableField("product_type")
	private String productType;
    /**
     * 资方名称
     */
	private String name;
    /**
     * 资方地址
     */
	private String address;
    /**
     * 资方简介
     */
	private String describe;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;
    /**
     * 更新时间
     */
	@TableField("update_time")
	private Date updateTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "CapitalInfo{" +
			", id=" + id +
			", productType=" + productType +
			", name=" + name +
			", address=" + address +
			", describe=" + describe +
			", createTime=" + createTime +
			", updateTime=" + updateTime +
			"}";
	}
}
