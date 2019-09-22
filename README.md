# Lemon_House

#### 简介

<strong style="color:blue">这是一个基于爬虫的新房/二手房租赁和销售数据展示和分析的网站。初定以下模块：</strong>

* 房产信息展示列表和详情页
* 区域二手房/新房售价总览和分析页
* ...

基于spring boot 2.1.8，数据库采用mysql，启动项目前请先运行项目根目录下的LemonHouse.sql文件

## 更新日志
* 2019-09-21 完善爬虫，修改表结构
* 2019-09-22 提供业务查询接口，使用mybatis-plus和jdbcTemplate混合开发，暂定去除spring-data-jpa，采用lombok简化开发流程
