package com.beautifulsoup.shiro.demo.entity;

/**
 * @Name: User
 * @Description: 用户信息的实体类
 * @Author: BeautifulSoup
 * @Date: 2017年12月16日 上午11:25:41
 */
public class User {
	private String uid;
	private String username;
	private String password;
	private String phone;
	private String address;
	private String salt;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
}
