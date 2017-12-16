package com.beautifulsoup.shiro.demo.authorization;

import java.util.Arrays;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @Name: AuthorizationTest.java
 * @Description: 进行权限的测试
 * @Author: BeautifulSoup
 * @Date: 2017年12月16日 下午1:09:10
 */
public class AuthorizationTest {
	
	/**
	 * testIniAuthorization
	 * @Description: 使用inirealm完成授权
	 * @return: void
	 * @Author: BeautifulSoup
	 * @Date: 2017年12月16日 下午3:05:34
	 */
	@Test
	@Ignore
	public void testIniAuthorization(){
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:permission-shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		//首先认证,认证通过之后才能授权
		UsernamePasswordToken token=new UsernamePasswordToken("beautifulsoup", "password");
		try{
			subject.login(token);
		}catch(AuthenticationException e){
			e.printStackTrace();
		}
		System.out.println("用户的认证状态:"+subject.isAuthenticated());
		boolean isPermitted=subject.isPermittedAll("user:create:01","user:query");
		subject.checkPermissions("user:create:01","user:query");
		System.out.println(isPermitted);
	}
	
	
	/**
	 * testCustomRealmAuthorization
	 * @Description: 使用自定义realm完成授权
	 * @return: void
	 * @Author: BeautifulSoup
	 * @Date: 2017年12月16日 下午3:05:46
	 */
	@Test
	public void testCustomRealmAuthorization(){
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:customrealm-shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		//首先认证,认证通过之后才能授权
		UsernamePasswordToken token=new UsernamePasswordToken("BeautifulSoup", "1997admin");
		try{
			subject.login(token);
		}catch(AuthenticationException e){
			e.printStackTrace();
		}
		System.out.println("用户的认证状态:"+subject.isAuthenticated());
		boolean isPermitted=subject.isPermittedAll("item:query");
		System.out.println(isPermitted);
	}
	
}
