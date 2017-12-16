package com.beautifulsoup.shiro.demo.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Name: ShiroDemoRealm.java
 * @Description: 自定义Realm完成用户认证与授权
 * @Author: BeautifulSoup
 * @Date: 2017年12月16日 上午2:21:58
 */
public class ShiroDemoRealm extends AuthorizingRealm{
	
	
	/**
	 * 完成授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		return null;
	}
	/**
	 * 完成认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username=(String) token.getPrincipal();
		
		return null;
	}
	
	
	
}
