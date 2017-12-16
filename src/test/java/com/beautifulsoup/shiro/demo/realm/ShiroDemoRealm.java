package com.beautifulsoup.shiro.demo.realm;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.beautifulsoup.shiro.demo.entity.User;
import com.beautifulsoup.shiro.demo.mapper.ShiroDemoMapper;
import com.beautifulsoup.shiro.demo.util.MyBatisUtil;

/**
 * @Name: ShiroDemoRealm.java
 * @Description: 自定义Realm完成用户认证与授权,数据从数据库中获取
 * @Author: BeautifulSoup
 * @Date: 2017年12月16日 上午2:21:58
 */
public class ShiroDemoRealm extends AuthorizingRealm{
	private static final String TAG= "CUSTOMREALM";
	
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
		ShiroDemoMapper mapper=getShiroMapper();
		User user = mapper.findByUsername(username);
		if(null!=user){
			SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(username, user.getPassword(),TAG);
			return authenticationInfo;
		}
		
		return null;
	}
	
	private ShiroDemoMapper getShiroMapper(){
		SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactory();
		SqlSession sqlSession = factory.openSession();
		ShiroDemoMapper mapper = sqlSession.getMapper(ShiroDemoMapper.class);
		return mapper;
	}
	
}
