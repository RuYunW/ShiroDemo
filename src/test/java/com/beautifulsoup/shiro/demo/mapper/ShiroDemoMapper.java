package com.beautifulsoup.shiro.demo.mapper;

import com.beautifulsoup.shiro.demo.entity.User;

/**
 * @Name: ShiroDemoMapper
 * @Description: 实现数据库增删改查
 * @Author: BeautifulSoup
 * @Date: 2017年12月16日 上午2:24:09
 */
public interface ShiroDemoMapper {
	User findByUsername(String username);
}
