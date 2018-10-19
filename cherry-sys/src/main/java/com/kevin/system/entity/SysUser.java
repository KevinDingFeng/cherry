package com.kevin.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 系统用户，平台用户
 * @author kevin
 *
 */
@Entity
@Table
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class SysUser  extends BaseEntity{

	/**
	 * 登录名 用户名
	 */
	@Column(nullable = false, length = 64)
	private String account;

	/**
	 * 是否激活
	 */
	private boolean active = true;

	/**
	 * 是否审核通过
	 */
	private boolean audited = true;

	/**
	 * 联系方式
	 */
	@Column(nullable = true, length = 32)
	private String cellphone;
	/**
	 * 联系方式是否通过了校验
	 */
	private boolean cellphoneVerified = false;

	/**
	 * 邮箱
	 */
	@Column(nullable = true, length = 255)
	private String email;
	/**
	 * 邮箱是否通过了校验
	 */
	private boolean emailVerified = false;

	/**
	 * 名称
	 */
	@Column(nullable = false, length = 64)
	private String name;
	/**
	 * 密码，加密加盐后的结果
	 */
	@JsonIgnore
	@Column(nullable = false, length = 200)
	private String password;

	/**
	 * 是否已删除
	 */
	private boolean removed = false;

	/**
	 * 系统标志
	 */
	@Column(nullable = true, length = 64)
	private String sysId;

}
