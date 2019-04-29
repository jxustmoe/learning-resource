#category data

INSERT INTO category (name, pid) VALUES ('网络工程',0);#1
INSERT INTO category (name, pid) VALUES ('通信工程',0);#2
INSERT INTO category (name, pid) VALUES ('信息安全',0);#3
INSERT INTO category (name, pid) VALUES ('软件工程',0);#4

#1
INSERT INTO category (name, pid) VALUES ('网络管理与维护',1);#5
INSERT INTO category (name, pid) VALUES ('无线网络技术',1);#6
INSERT INTO category (name, pid) VALUES ('综合楼布线',1);#7

#2
INSERT INTO category (name, pid) VALUES ('通信工程1',2);#8
INSERT INTO category (name, pid) VALUES ('通信工程2',2);#9
INSERT INTO category (name, pid) VALUES ('通信工程3',2);#10
INSERT INTO category (name, pid) VALUES ('通信工程4',2);#11

#3
INSERT INTO category (name, pid) VALUES ('网络安全',3);#12
INSERT INTO category (name, pid) VALUES ('网路渗透技术',3);#13
INSERT INTO category (name, pid) VALUES ('系统安全',3);#14

#4
INSERT INTO category (name, pid) VALUES ('软件维护',4);#15
INSERT INTO category (name, pid) VALUES ('软件测试',4);#16




#resource data
INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('网络管理与维护考试答案',5,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('无线网络技术考试答案',6,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('综合楼布线考试答案',7,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('通信工程1考试答案',8,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('通信工程2考试答案',9,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('通信工程3考试答案',10,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('通信工程4考试答案',11,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('网络安全考试答案',12,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('网路渗透技术考试答案',13,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('系统安全考试答案',14,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('软件维护考试答案',15,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('软件测试考试答案',16,'baidu.com','1998');




#删除与更改测试
INSERT INTO category (name, pid) VALUES ('待删除父目录1',0);#17
INSERT INTO category (name, pid) VALUES ('待删除父目录2',0);#18
INSERT INTO category (name, pid) VALUES ('待删除子目录1_1',0);#19
INSERT INTO category (name, pid) VALUES ('待删除子目录1_2',0);#20
INSERT INTO category (name, pid) VALUES ('待删除子目录2_1',0);#21
INSERT INTO category (name, pid) VALUES ('待删除子目录2_2',0);#22

INSERT INTO category (name, pid) VALUES ('存放资源父目录3',0);#23
INSERT INTO category (name, pid) VALUES ('存放资源子目录3_1',23);#24

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('资源1',24,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('资源2',24,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('资源3',24,'baidu.com','1998');

INSERT INTO resource (name, categoryid, link, uploadtime)
              VALUES ('资源4',24,'baidu.com','1998');
