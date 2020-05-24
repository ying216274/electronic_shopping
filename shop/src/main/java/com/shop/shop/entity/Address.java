package com.shop.shop.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * 地址实体类
 */

@Data
@TableName(value = "bs_address")
public class Address extends Model<Address> {
	@TableId(type = IdType.AUTO)
	private int id;
	private int userId;
	private String province;
	private String city;
	private String area;
	private String detailAddress;
	private String emailCode;
	private String receiver;
	private String tel;
	private String isDefault; //是否是默认收货地址
}