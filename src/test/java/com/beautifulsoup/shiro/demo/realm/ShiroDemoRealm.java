package com.beautifulsoup.shiro.demo.realm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.beautifulsoup.shiro.demo.entity.Permission;
import com.beautifulsoup.shiro.demo.entity.User;
import com.beautifulsoup.shiro.demo.mapper.ShiroDemoMapper;
import com.beautifulsoup.shiro.demo.mapper.UserCustomMapper;
import com.beautifulsoup.shiro.demo.util.MyBatisUtil;
import com.beautifulsoup.shiro.demo.vo.RoleCustom;
import com.beautifulsoup.shiro.demo.vo.UserCustom;

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
		//得到认证成功之后凭证的身份信息
		String username=(String) principals.getPrimaryPrincipal();
		//查询数据库得到所有的权限列表
		List<String> permissionList=new ArrayList<String>();
		UserCustomMapper mapper=getUserCustomMapper();
		UserCustom userCustom = mapper.findUserCustomByUsername(username);
		Set<RoleCustom> roles=userCustom.getRoleSet();
		for(RoleCustom role:roles){
			Set<Permission> permissionSet = role.getPermissionSet();
			for (Permission permission:permissionSet) {
				permissionList.add(permission.getPname());
			}
		}
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions(permissionList);
		return authorizationInfo;
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
			SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(username, user.getPassword(),
					ByteSource.Util.bytes(user.getSalt()),TAG);
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
	
	private UserCustomMapper getUserCustomMapper(){
		SqlSessionFactory factory = MyBatisUtil.getSqlSessionFactory();
		SqlSession sqlSession = factory.openSession();
		UserCustomMapper mapper = sqlSession.getMapper(UserCustomMapper.class);
		return mapper;
	}
}
