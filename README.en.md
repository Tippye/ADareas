# ADareas

#### Description
China Regional Database

#### Software Architecture
Software architecture description

Use open APIs such as AutoNavi and Tencent to create a standard Chinese regional database

#### Installation

- DATABASE
    1.  Create database
    2.  execute areas.sql to add data table
    3.  execute areas_data.sql to add datas
- CODE
    1.  pull the code locally
    2.  change /src/main/resources/application.yml, modify the database configuration to your own local database
    3.  change /src/main/java/com.adareas/api/Request.java KEYs to yours
    4.  run /src/main/java/com.adareas/AdareasApplication.java main


#### Instructions

1.  under /src/main/java/com.adareas/controller/AreaController.java file's function to request api

#### Feature

1.  Use open interfaces such as Amap Maps and Tencent Maps to obtain data
2.  Standard Chinese regionalization database
3.  Open source, you can call the update method to update data by yourself