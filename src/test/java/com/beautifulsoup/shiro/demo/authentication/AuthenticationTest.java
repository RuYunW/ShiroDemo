package com.beautifulsoup.shiro.demo.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @Name: AuthenticationTest.java
 * @Description: 使用Shiro完成用户认证
 * @Author: BeautifulSoup
 * @Date: 2017年12月16日 上午2:16:47
 */
public class AuthenticationTest {
	
	@Test
	public void testIniRealm(){
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:inirealm-shiro.ini");
		SecurityManager securityManager = factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("james_shu", "1997admin");
		try{
			subject.login(token);
		}catch(AuthenticationException e){
			e.printStackTrace();
		}
		System.out.println("用户认证状态:"+subject.isAuthenticated());
		subject.logout();
		System.out.println("用户当前认证状态:"+subject.isAuthenticated());
	}
	
	
	
	
}
