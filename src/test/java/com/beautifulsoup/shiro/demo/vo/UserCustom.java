package com.beautifulsoup.shiro.demo.vo;

import java.util.HashSet;
import java.util.Set;

import com.beautifulsoup.shiro.demo.entity.Role;
import com.beautifulsoup.shiro.demo.entity.User;

/**
 * @Name: UserCustom.java
 * @Description: 自定义的扩展类
 * @Author: BeautifulSoup
 * @Date: 2017年12月16日 下午2:19:28
 */
public class UserCustom extends User{
	private Set<RoleCustom> roleSet=new HashSet<>();

	public Set<RoleCustom> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<RoleCustom> roleSet) {
		this.roleSet = roleSet;
	}
	
}
