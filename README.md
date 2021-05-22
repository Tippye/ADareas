# ADareas

#### 介绍
中国区划数据库

#### 软件架构
软件架构说明

使用高德、腾讯等开放api创建标准的中国区划数据库

#### 安装教程

- 数据库
    1.  创建数据库
    2.  执行areas.sql添加数据表
    3.  执行areas_data.sql添加数据
- 代码
    1.  将代码拉取到本地
    2.  修改/src/main/resources/application.yml文件，将数据库配置修改为自己本地数据库
    3.  修改/src/main/java/com.adareas/api/Request.java中的开发者密钥
    4.  运行/src/main/java/com.adareas/AdareasApplication.java的main方法

#### 使用说明

1.  根据/src/main/java/com.adareas/controller/AreaController.java中的方法请求api

#### 特技

1.  使用高德地图、腾讯地图等开放接口获取数据
2.  标准的中国区划数据库
3.  开放源码，可自行调用update方法进行数据更新