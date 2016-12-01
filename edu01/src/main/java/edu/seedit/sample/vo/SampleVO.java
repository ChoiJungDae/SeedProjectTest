package edu.seedit.sample.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;

public class SampleVO {
	@NotNull @Min(8) @Max(15)
	private String userId         = null;// �궗�슜�옄ID
	private String userName       = null;// �궗�슜�옄�씠由�
	private String userPhone      = null;// �쑕���룿踰덊샇
	@Email
	private String userEmail      = null;// �씠硫붿씪二쇱냼
	private String corpCode       = null;// �뾽泥� 肄붾뱶
	private String userLevel      = null;// �궗�슜�옄�벑湲�
	private String userDepartment = null;// 遺��꽌
	private String corpName       = null;// �뾽泥대챸
	private String corpLevel      = null;// �뾽泥대벑湲�
	private String profileName    = null;// �봽濡쒗븘 �궗吏꾪뙆�씪 �씠由�
	private String departmentName = null;// 遺��꽌紐�
	private String userRankname   = null;// �궗�슜�옄�벑湲됰챸

	/**
	 * toString 硫붿냼�뱶瑜� ��移섑븳�떎.
	*/
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}

	/**
	 *  �궗�슜�옄ID
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 *  �궗�슜�옄ID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 *  �궗�슜�옄�씠由�
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 *  �궗�슜�옄�씠由�
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 *  �쑕���룿踰덊샇
	 */
	public String getUserPhone() {
		return userPhone;
	}
	/**
	 *  �쑕���룿踰덊샇
	 */
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	/**
	 *  �씠硫붿씪二쇱냼
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 *  �씠硫붿씪二쇱냼
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 *  �뾽泥� 肄붾뱶
	 */
	public String getCorpCode() {
		return corpCode;
	}
	/**
	 *  �뾽泥� 肄붾뱶
	 */
	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}
	/**
	 *  �궗�슜�옄�벑湲�
	 */
	public String getUserLevel() {
		return userLevel;
	}
	/**
	 *  �궗�슜�옄�벑湲�
	 */
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	/**
	 *  遺��꽌
	 */
	public String getUserDepartment() {
		return userDepartment;
	}
	/**
	 *  遺��꽌
	 */
	public void setUserDepartment(String userDepartment) {
		this.userDepartment = userDepartment;
	}
	/**
	 *  �뾽泥대챸
	 */
	public String getCorpName() {
		return corpName;
	}
	/**
	 *  �뾽泥대챸
	 */
	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}
	/**
	 *  �뾽泥대벑湲�
	 */
	public String getCorpLevel() {
		return corpLevel;
	}
	/**
	 *  �뾽泥대벑湲�
	 */
	public void setCorpLevel(String corpLevel) {
		this.corpLevel = corpLevel;
	}
	/**
	 *  �봽濡쒗븘 �궗吏꾪뙆�씪 �씠由�
	 */
	public String getProfileName() {
		return profileName;
	}
	/**
	 *  �봽濡쒗븘 �궗吏꾪뙆�씪 �씠由�
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	/**
	 *  遺��꽌紐�
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 *  遺��꽌紐�
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**
	 *  �궗�슜�옄�벑湲됰챸
	 */
	public String getUserRankname() {
		return userRankname;
	}
	/**
	 *  �궗�슜�옄�벑湲됰챸
	 */
	public void setUserRankname(String userRankname) {
		this.userRankname = userRankname;
	}

}
