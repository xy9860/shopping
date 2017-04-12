/*
 * ER/Studio 8.0 SQL Code Generation
 * Company :      JP
 * Project :      Model1.DM1
 * Author :       SkyUN.Org
 *
 * Date Created : Wednesday, November 30, 2011 16:31:14
 * Target DBMS : Microsoft SQL Server 2005
 */
 
 select * from goods g inner join category c on g.cid=c.cid where c.ctype like '%男士%'
 select * from goods g inner join category c on g.cid=c.cid  where g.gname like '%%' or g.gremark like '%%'
 
 
 select * from account
 
 select * from category
 
 select * from forder
 
 select * from  goods
 
 select * from  sorder
 
 select * from status
 
 select * from users
 
 update goods set gpic='1.jpg'
 
IF OBJECT_ID('sorder') IS NOT NULL
BEGIN
    DROP TABLE sorder
    PRINT '<<< DROPPED TABLE sorder >>>'
END
go

IF OBJECT_ID('forder') IS NOT NULL
BEGIN
    DROP TABLE forder
    PRINT '<<< DROPPED TABLE forder >>>'
END
go


IF OBJECT_ID('goods') IS NOT NULL
BEGIN
    DROP TABLE goods
    PRINT '<<< DROPPED TABLE goods >>>'
END
go

IF OBJECT_ID('category') IS NOT NULL
BEGIN
    DROP TABLE category
    PRINT '<<< DROPPED TABLE category >>>'
END
go

IF OBJECT_ID('account') IS NOT NULL
BEGIN
    DROP TABLE account
    PRINT '<<< DROPPED TABLE account >>>'
END
go

IF OBJECT_ID('status') IS NOT NULL
BEGIN
    DROP TABLE status
    PRINT '<<< DROPPED TABLE status >>>'
END
go
IF OBJECT_ID('users') IS NOT NULL
BEGIN
    DROP TABLE users
    PRINT '<<< DROPPED TABLE users >>>'
END
go


CREATE TABLE account(
    aid       int             IDENTITY(1,1),
    alogin    nvarchar(20)    NOT NULL,
    aname     nvarchar(20)    NULL,
    apass     nvarchar(20)    NULL,
    CONSTRAINT PK4 PRIMARY KEY NONCLUSTERED (aid)
)
go



IF OBJECT_ID('account') IS NOT NULL
    PRINT '<<< CREATED TABLE account >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE account >>>'
go

/* 
 * TABLE: category 
 */

CREATE TABLE category(
    cid      int             IDENTITY(1,1),
    ctype    nvarchar(20)    NOT NULL,
    chot     bit             DEFAULT 'false' NULL,
    aid      int             NOT NULL,
    CONSTRAINT PK6 PRIMARY KEY NONCLUSTERED (cid)
)
go



IF OBJECT_ID('category') IS NOT NULL
    PRINT '<<< CREATED TABLE category >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE category >>>'
go

/* 
 * TABLE: forder 
 */

CREATE TABLE forder(
    fid        int             IDENTITY(2011113001,1),
    fdate      datetime        DEFAULT getdate() NOT NULL,
    ftotal     nvarchar(20)    NOT NULL,
    fname      nvarchar(20)    NOT NULL,
    fphone     nvarchar(20)    NOT NULL,
    fremark    nvarchar(50)    NOT NULL,
    femail     nvarchar(20)    NOT NULL,
    fpost      nvarchar(10)    NOT NULL,
    uid        int             NOT NULL,
    aid        int             NULL,
    sid        int             NOT NULL,
    CONSTRAINT PK7 PRIMARY KEY NONCLUSTERED (fid)
)
go



IF OBJECT_ID('forder') IS NOT NULL
    PRINT '<<< CREATED TABLE forder >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE forder >>>'
go

/* 
 * TABLE: goods 
 */

CREATE TABLE goods(
    gid           int                 IDENTITY(20111012,1),
    gname         nvarchar(20)        NOT NULL,
    gprice        double precision    NOT NULL,
    gpic          nvarchar(100)       NOT NULL,
    gremark       nvarchar(500)       NOT NULL,
    gxremark      nvarchar(1000)      NULL,
    gdate         datetime            DEFAULT getdate() NOT NULL,
    giscommend    bit                 DEFAULT 'false' NOT NULL,
    gisopen       bit                 DEFAULT 'true' NOT NULL,
    cid           int                 NOT NULL,
    CONSTRAINT PK3 PRIMARY KEY NONCLUSTERED (gid)
)
go



IF OBJECT_ID('goods') IS NOT NULL
    PRINT '<<< CREATED TABLE goods >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE goods >>>'
go

/* 
 * TABLE: sorder 
 */

CREATE TABLE sorder(
    sid        int             IDENTITY(1,1),
    sname      nvarchar(20)    NULL,
    sprice     float           NULL,
    snumber    int             NULL,
    fid        int             NOT NULL,
    gid        int             NOT NULL,
    CONSTRAINT PK8 PRIMARY KEY NONCLUSTERED (sid)
)
go



IF OBJECT_ID('sorder') IS NOT NULL
    PRINT '<<< CREATED TABLE sorder >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE sorder >>>'
go

/* 
 * TABLE: status 
 */

CREATE TABLE status(
    sid       int             IDENTITY(1,1),
    status    nvarchar(20)    NOT NULL,
    CONSTRAINT PK5 PRIMARY KEY NONCLUSTERED (sid)
)
go



IF OBJECT_ID('status') IS NOT NULL
    PRINT '<<< CREATED TABLE status >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE status >>>'
go

/* 
 * TABLE: users 
 */

CREATE TABLE users(
    uid         int             IDENTITY(1,1),
    ulogin      nvarchar(20)    NOT NULL,
    uname       nvarchar(20)    NOT NULL,
    upass       nvarchar(20)    NOT NULL,
    usex        nvarchar(2)     NOT NULL,
    uphone      nvarchar(20)    NULL,
    upost       nvarchar(20)    NULL,
    uemail      nvarchar(20)    NULL,
    uaddress    nvarchar(20)    NULL,
    CONSTRAINT PK2 PRIMARY KEY NONCLUSTERED (uid)
)
go



IF OBJECT_ID('users') IS NOT NULL
    PRINT '<<< CREATED TABLE users >>>'
ELSE
    PRINT '<<< FAILED CREATING TABLE users >>>'
go

/* 
 * INDEX: Ref41 
 */

CREATE INDEX Ref41 ON category(aid)
go
IF EXISTS (SELECT * FROM sys.indexes WHERE object_id=OBJECT_ID('category') AND name='Ref41')
    PRINT '<<< CREATED INDEX category.Ref41 >>>'
ELSE
    PRINT '<<< FAILED CREATING INDEX category.Ref41 >>>'
go

/* 
 * INDEX: Ref23 
 */

CREATE INDEX Ref23 ON forder(uid)
go
IF EXISTS (SELECT * FROM sys.indexes WHERE object_id=OBJECT_ID('forder') AND name='Ref23')
    PRINT '<<< CREATED INDEX forder.Ref23 >>>'
ELSE
    PRINT '<<< FAILED CREATING INDEX forder.Ref23 >>>'
go

/* 
 * INDEX: Ref45 
 */

CREATE INDEX Ref45 ON forder(aid)
go
IF EXISTS (SELECT * FROM sys.indexes WHERE object_id=OBJECT_ID('forder') AND name='Ref45')
    PRINT '<<< CREATED INDEX forder.Ref45 >>>'
ELSE
    PRINT '<<< FAILED CREATING INDEX forder.Ref45 >>>'
go

/* 
 * INDEX: Ref56 
 */

CREATE INDEX Ref56 ON forder(sid)
go
IF EXISTS (SELECT * FROM sys.indexes WHERE object_id=OBJECT_ID('forder') AND name='Ref56')
    PRINT '<<< CREATED INDEX forder.Ref56 >>>'
ELSE
    PRINT '<<< FAILED CREATING INDEX forder.Ref56 >>>'
go

/* 
 * INDEX: Ref62 
 */

CREATE INDEX Ref62 ON goods(cid)
go
IF EXISTS (SELECT * FROM sys.indexes WHERE object_id=OBJECT_ID('goods') AND name='Ref62')
    PRINT '<<< CREATED INDEX goods.Ref62 >>>'
ELSE
    PRINT '<<< FAILED CREATING INDEX goods.Ref62 >>>'
go

/* 
 * INDEX: Ref74 
 */

CREATE INDEX Ref74 ON sorder(fid)
go
IF EXISTS (SELECT * FROM sys.indexes WHERE object_id=OBJECT_ID('sorder') AND name='Ref74')
    PRINT '<<< CREATED INDEX sorder.Ref74 >>>'
ELSE
    PRINT '<<< FAILED CREATING INDEX sorder.Ref74 >>>'
go

/* 
 * INDEX: Ref37 
 */

CREATE INDEX Ref37 ON sorder(gid)
go
IF EXISTS (SELECT * FROM sys.indexes WHERE object_id=OBJECT_ID('sorder') AND name='Ref37')
    PRINT '<<< CREATED INDEX sorder.Ref37 >>>'
ELSE
    PRINT '<<< FAILED CREATING INDEX sorder.Ref37 >>>'
go

/* 
 * TABLE: category 
 */

ALTER TABLE category ADD CONSTRAINT Refaccount1 
    FOREIGN KEY (aid)
    REFERENCES account(aid)
go


/* 
 * TABLE: forder 
 */

ALTER TABLE forder ADD CONSTRAINT Refusers3 
    FOREIGN KEY (uid)
    REFERENCES users(uid)
go

ALTER TABLE forder ADD CONSTRAINT Refaccount5 
    FOREIGN KEY (aid)
    REFERENCES account(aid)
go

ALTER TABLE forder ADD CONSTRAINT Refstatus6 
    FOREIGN KEY (sid)
    REFERENCES status(sid)
go


/* 
 * TABLE: goods 
 */

ALTER TABLE goods ADD CONSTRAINT Refcategory2 
    FOREIGN KEY (cid)
    REFERENCES category(cid)
go


/* 
 * TABLE: sorder 
 */

ALTER TABLE sorder ADD CONSTRAINT Refforder4 
    FOREIGN KEY (fid)
    REFERENCES forder(fid)
go

ALTER TABLE sorder ADD CONSTRAINT Refgoods7 
    FOREIGN KEY (gid)
    REFERENCES goods(gid)
go


--测试用例

SELECT * FROM users;

INSERT INTO users VALUES ('u1','小明','u1','男','13877985456','424435','10000@qq.com','湖南长沙');
INSERT INTO users VALUES ('u1','小云','u2','女','13977985456','424435','10001@qq.com','中国北京');
go

SELECT * FROM account;

INSERT INTO account VALUES ('a1','小王','a1');
INSERT INTO account VALUES ('a2','小张','a2');
go

SELECT * FROM status;

INSERT INTO status VALUES ('未支付');
INSERT INTO status VALUES ('已支付');
INSERT INTO status VALUES ('废单');

SELECT * FROM category

INSERT INTO category VALUES ('男士休闲','true',1);
INSERT INTO category VALUES ('女士休闲','false',2);
go

SELECT * FROM goods

INSERT INTO goods VALUES ('爱国者mp3',0.01,'1.jpg','爱国者品牌','可以连续听歌n小时',DEFAULT,'TRUE','TRUE',1)
INSERT INTO goods VALUES ('惠普电脑',0.1,'2.jpg','HP品牌','4G内存,500GB硬盘.....',DEFAULT,'TRUE','FALSE',1)
go

SELECT * FROM forder;

INSERT INTO forder VALUES (getdate(),4400,'小敏','13245678','周六周日不要配送','33333@qq.com','424412',1,null,1);
go

SELECT * FROM sorder;

INSERT INTO sorder VALUES ('爱国者mp3',399,1,2011113001,20111012);
INSERT INTO sorder VALUES ('惠普电脑',4001,1,2011113001,20111013);
go

