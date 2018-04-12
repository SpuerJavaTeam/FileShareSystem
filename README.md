# 文件共享系统开发文档

*特别感谢：此项目是由我的组员Ying Z, Ping T, SiCheng L, PengGeYang X和我共同完成。组员及我拥有对该项目的全部解释权。*

*此项目使用intellij Idea开发，感谢jetBrains公司研发的产品。*

## 系统要求
开发工具：Intellij IDEA 

## 功能设计

* 用户功能：
* * 登录（用户名、密码）
* * 注册（用户名、密码、邮箱）
* * 账户管理（密码修改，邮箱修改）
* * 资料修改（性别、年龄、手机号码等）

* 文件部分：
* * 用户文件页（收藏文件->数目、浏览文件->数目、下载文件->书目）
* * 上传文件（文件名称、文件类型、文件大小、文件上传日期、是否通过审核）
* * 收藏的文件
* * 下载的文件
* * 文件举报（反馈）
* * 文件管理（重命名、删除、下载、文件状态选择（私有、公开））

* 超级管理员：
* * 文件审核机制（默认通过->记录过审文件）
* * 用户管理
* * 文件管理（删除、重命名）

*管理员删除文件时仅修改数据表的status状态，并且删除本地文件。由用户删除的文件将删除本地文件和数据库记录*


* 功能性组件：
* * 分页
* * 批量管理（审核、下载、用户管理）
* * 图片验证码(session)
* * Ajax（选配）


## 数据库设计
用户表

    +----------------------------------------------------------------+
    |       user                                                     |
    +----------+-------------+------+-----+---------+----------------+
    | Field    | Type        | Null | Key | Default | Extra          |
    +----------+-------------+------+-----+---------+----------------+
    | uid      | varchar(50) | NO   | PRI | NULL    |                |      ------ 用户id（md5值）
    | username | varchar(50) | NO   | Unq | NULL    |                |      ------ 用户名（唯一）
    | password | varchar(50) | NO   |     | NULL    |                |      ------ 用户密码(md5值)
    | email    | varchar(50) | No   |     | NULL    |                |      ------ 用户邮箱
    | status   | int(1)      | No   |     | 1       |                |      ------ 帐号状态（0为停用，1为启用）
    | type     | int(1)      | No   |     | 1       |                |      ------ 帐号类型（0为管理员，1为普通用户）
    |created_at| timestamp   | No   |     | NULL    |                |      ------ 创建时间
    |updated_at| timestamp   | No   |     | NULL    |                |      ------ 修改时间
    +----------+-------------+------+-----+---------+----------------+

    create table filesharesystem.user(
        uid varchar(50) not null,
        username varchar(50) not null unique,
        password varchar(50) not null,
        email varchar(50) not null,
        status int(1) not null default 1,
        type int(1) not null default 1,
        created_at timestamp not null,
        updated_at timestamp not null,
        primary key(uid)
    )

用户信息扩展表

    +----------------------------------------------------------------+
    |       userdata                                                 |
    +----------+-------------+------+-----+---------+----------------+
    | Field    | Type        | Null | Key | Default | Extra          |
    +----------+-------------+------+-----+---------+----------------+
    | uid      | varchar(50) | NO   | FRO | NULL    |                |      ------ 用户id（md5值）
    | gender   | int(1)      | No   |     | 2       |                |      ------ 性别(女->0、男->1、保密->2)
    | age      | int(3)      | No   |     | 0       |                |      ------ 年龄
    | birthday | date        | NO   |     | NULL    |                |      ------ 生日
    | QQ       | varchar(15) | NO   |     | NULL    |                |      ------ QQ
    | phone    | varchar(12) | NO   |     | NULL    |                |      ------ 手机
    |created_at| timestamp   | No   |     | NULL    |                |      ------ 创建时间
    |updated_at| timestamp   | No   |     | NULL    |                |      ------ 修改时间
    +----------+-------------+------+-----+---------+----------------+

    create table filesharesystem.userdata(
        uid varchar(50) not null unique,
        gender int(1) not null default 2,
        age int(3) not null default 0,
        birthday date default null,
        QQ varchar(15) default null,
        phone varchar(12) default null,
        created_at timestamp not null,
        updated_at timestamp not null,
        foreign key(uid) references user(uid),
        check(age>0 and age<200)
    )

IP地址记录表

    +----------------------------------------------------------------+
    |       ip                                                       |
    +----------+-------------+------+-----+---------+----------------+
    | Field    | Type        | Null | Key | Default | Extra          |      ------ 仅在用户登陆时进行记录
    +----------+-------------+------+-----+---------+----------------+
    | id       | int         | No   | PRI | NULL    | auto_increment |      ------ ip记录数
    | uid      | varchar(50) | NO   | For | NULL    |                |      ------ 用户id（md5值）
    | ipv4     | varchar(15) | NO   |     | NULL    |                |      ------ ipv4地址
    |created_at| timestamp   | No   |     | NULL    |                |      ------ 创建时间
    |updated_at| timestamp   | No   |     | NULL    |                |      ------ 修改时间
    +----------+-------------+------+-----+---------+----------------+

    create table filesharesystem.ip(
        id int auto_increment,
        uid varchar(50) not null,
        ipv4 varchar(15) not null,
        created_at timestamp not null,
        updated_at timestamp not null,
        primary key(id),
        foreign key(uid) references user(uid)
    )

文件表

    +----------------------------------------------------------------+
    |       file                                                     |
    +----------+-------------+------+-----+---------+----------------+
    | Field    | Type        | Null | Key | Default | Extra          |
    +----------+-------------+------+-----+---------+----------------+
    | fid      | varchar(50) | NO   | Pri | NULL    |                |      ------ 文件id（md5值）
    | fileName | varchar(200)| NO   |     | NULL    |                |      ------ 文件名称
    | fileType | varchar(20) | No   |     | NULL    |                |      ------ 文件格式
    | path     | varchar(500)| NO   |     | NULL    |                |      ------ 文件保存路径(绝对)
    | uid      | varchar(50) | No   | For | NULL    |                |      ------ 用户id（md5值）
    | status   | int(1)      | No   |     | 1       |                |      ------ 文件状态（0为未通过审核，1为通过审核，2为被举报，3为被管理员删除）
    | type     | int(1)      | No   |     | 1       |                |      ------ 文件私有化（0为私有，1为公开）
    |created_at| timestamp   | No   |     | NULL    |                |      ------ 创建时间
    |updated_at| timestamp   | No   |     | NULL    |                |      ------ 修改时间
    +----------+-------------+------+-----+---------+----------------+

    create table filesharesystem.file(
        fid varchar(50) not null,
        filename varchar(200) not null,
        filetype varchar(20) not null,
        uid varchar(50) not null,
        status int(1) not null default 1,
        type int(1) not null default 1,
        created_at timestamp not null,
        updated_at timestamp not null,
        primary key(fid),
        foreign key(uid) references user(uid)
    )

文件扩展表

    +----------------------------------------------------------------+
    |       filedata                                                 |
    +----------+-------------+------+-----+---------+----------------+
    | Field    | Type        | Null | Key | Default | Extra          |
    +----------+-------------+------+-----+---------+----------------+
    | id       | int(11)     | NO   | Pri | NULL    | auto_increment |      ------ 记录id（自增）
    | visitorid| varchar(50) | NO   | Fro | NULL    |                |      ------ 操作者id（md5值）
    | fid      | varchar(50) | No   |     | NULL    |                |      ------ 文件id（md5值）
    | type     | int(1)      | No   |     | NULL    |                |      ------ 操作状态（1为浏览、2为收藏、3为下载）
    |created_at| timestamp   | No   |     | NULL    |                |      ------ 创建时间
    |updated_at| timestamp   | No   |     | NULL    |                |      ------ 修改时间
    +----------+-------------+------+-----+---------+----------------+

    create table filesharesystem.filedata(
        id int auto_increment,
        visitorid varchar(50) not null,
        fid varchar(50) not null,
        type int(1) not null,
        created_at timestamp not null,
        updated_at timestamp not null,
        primary key(id),
        foreign key(visitorid) references user(uid),
        foreign key(fid) references file(fid)
    )

文件评论表

    +----------------------------------------------------------------+
    |       filedata                                                 |
    +----------+-------------+------+-----+---------+----------------+
    | Field    | Type        | Null | Key | Default | Extra          |
    +----------+-------------+------+-----+---------+----------------+
    | id       | int(11)     | NO   | Pri | NULL    | auto_increment |      ------ 记录id（自增）
    | authorid | varchar(50) | NO   | Fro | NULL    |                |      ------ 发布者id（md5值）
    | visitorid| varchar(50) | NO   | Fro | NULL    |                |      ------ 操作者id（md5值）
    | fid      | varchar(50) | No   |     | NULL    |                |      ------ 文件id（md5值）
    | level    | int(1)      | YES  |     | 0       |                |      ------ 文件评级状态（1~5）
    | commit   | varchar(500)| YES  |     | null    |                |      ------ 文件评论
    |created_at| timestamp   | No   |     | NULL    |                |      ------ 创建时间
    |updated_at| timestamp   | No   |     | NULL    |                |      ------ 修改时间
    +----------+-------------+------+-----+---------+----------------+

    create table filesharesystem.filedata(
        id int auto_increment,
        authorid varchar(50) not null,
        visitorid varchar(50) not null,
        fid varchar(50) not null,
        level int(1) default 0,
        commit varchar(500) default null,
        created_at timestamp not null,
        updated_at timestamp not null,
        primary key(id),
        foreign key(authorid) references user(uid),
        foreign key(visitorid) references user(uid),
        foreign key(fid) references file(fid),
        check(level>0 and level <6)
    )

## 功能实现思路
文件浏览记录:使用ajax异步传输数据,或者采用用户点击的方式进行数据的保存.

## 程序设计
### intellij idea文件目录结构

    + FileShareSystem
    |--- .idea
        |--- 存放idea环境信息
    |--- lib
        |--- 存放依赖包
    |--- out
        |--- 存放输出的war包
    |--- src
        |--- 存放Action源码
    |--- web
        |--- 存放网页的资源文件，页面文件等
    |--- WEB-INF
        |--- web.xml配置，进行Struts拦截配置
    |--- FileShareSystem.iml

### 参考资料
	
* [struts2的文件上传和文件下载](https://www.cnblogs.com/biehongli/p/6509557.html)