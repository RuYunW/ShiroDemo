-- �û���Ϣ��
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL DEFAULT '' COMMENT '�û���',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '����',
  `phone` varchar(11) DEFAULT NULL COMMENT '�ֻ���',
  `address` varchar(100) DEFAULT NULL COMMENT '��ַ',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���Ϣ��';
-- ��ɫ��Ϣ��
CREATE TABLE `role` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rname` varchar(50) NOT NULL DEFAULT 'ordinary_user' COMMENT '��ͨ�û�',
  `rdesc` varchar(100) DEFAULT NULL COMMENT '������Ϣ',
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɫ��Ϣ��';
-- Ȩ����Ϣ��
CREATE TABLE `permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(50) NOT NULL DEFAULT 'query' COMMENT 'Ȩ������',
  `url` varchar(100) DEFAULT NULL COMMENT '���ص���Դurl',
  `pdesc` varchar(100) DEFAULT NULL COMMENT 'Ȩ����Ϣ����',
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Ȩ����Ϣ��';
-- �û���ɫ��
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL DEFAULT '1' COMMENT '�û�������id',
  `rid` int(11) NOT NULL DEFAULT '1' COMMENT '��ɫ������id',
  PRIMARY KEY (`id`),
  KEY `fk_userid` (`uid`),
  KEY `fk_roleid` (`rid`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `fk_roleid` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���ɫ��Ϣ��';
-- ��ɫȨ�ޱ�
CREATE TABLE `permission_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) NOT NULL DEFAULT '1' COMMENT '��ɫ������id',
  `pid` int(11) NOT NULL DEFAULT '1' COMMENT 'Ȩ�޵�����id',
  PRIMARY KEY (`id`),
  KEY `fk_rid` (`rid`),
  KEY `fk_pid` (`pid`),
  CONSTRAINT `fk_pid` FOREIGN KEY (`pid`) REFERENCES `permission` (`pid`),
  CONSTRAINT `fk_rid` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɫȨ����Ϣ��';
