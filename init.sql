-- 用户信息表
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '密码',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';
-- 角色信息表
CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(50) NOT NULL DEFAULT 'ordinary_user' COMMENT '普通用户',
  `rdesc` varchar(100) DEFAULT NULL COMMENT '描述信息',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色信息表';
-- 权限信息表
CREATE TABLE `permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) NOT NULL DEFAULT 'query' COMMENT '权限名称',
  `url` varchar(100) DEFAULT NULL COMMENT '拦截的资源url',
  `pdesc` varchar(100) DEFAULT NULL COMMENT '权限信息描述',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限信息表';
-- 用户角色表
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '1' COMMENT '用户的主键id',
  `rid` int(11) NOT NULL DEFAULT '1' COMMENT '角色的主键id',
  PRIMARY KEY (`id`),
  KEY `fk_userid` (`uid`),
  KEY `fk_roleid` (`rid`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `fk_roleid` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色信息表';
-- 角色权限表
CREATE TABLE `permission_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL DEFAULT '1' COMMENT '角色的主键id',
  `pid` int(11) NOT NULL DEFAULT '1' COMMENT '权限的主键id',
  PRIMARY KEY (`id`),
  KEY `fk_rid` (`rid`),
  KEY `fk_pid` (`pid`),
  CONSTRAINT `fk_pid` FOREIGN KEY (`pid`) REFERENCES `permission` (`pid`),
  CONSTRAINT `fk_rid` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限信息表';
