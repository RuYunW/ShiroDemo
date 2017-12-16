package com.beautifulsoup.shiro.demo.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory sessionFactory=null;
	public static SqlSessionFactory getSqlSessionFactory(){
		if(null==sessionFactory){
			try{
				String path="SqlMapConfig.xml";
				sessionFactory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(path));
			}catch(Exception e){
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
}
