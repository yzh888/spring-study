# 关于Spring的配置和注解说明
### 1. 关于xml方式来做bean的配置
- <bean>标签的使用注意:id class
- 构造器注入:ref引用其他对象
- setter注入: property或p:简写形式
### 2. 两种方式获取xml中的bean
- Application得到上下文， ac.getBean("bean id名称"),再main方法中使用
- @Autowired注解，单元测试使用，注解命名规范
### 3. 基础Java类来做bean的配置（主流，常用，为了减少xml）
- 配置类要加上@Configuration
- 配置中配置bean的方法，要加上@Bean注解
```$xslt
@Bean
    public Forum forum() {
        return new Forum();
    }
```
### 4. 如何再SpringFramework中获得Java类配置的bean?
- main 
```$xslt
//生成基于注解配置的应用上下文对象
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        //scan手动扫包
        ctx.scan("com.soft1851.ioc.config");
        Forum forum = (Forum) ctx.getBean("forum");
        forum.setForumId(2);
        forum.setForumName("老颜");
        System.out.println(forum);
```
- 单元测试
> 注意再xml配置文件中手动开启扫包
```$xslt
<context:component-scan base-package="com.soft1851.ioc.config"/>
```
### 5. Spring集成JDBC步骤
- 在resources文件夹下新建db.properties文件
- 在db.properties文件中写入数据库驱动，账户密码
```$xslt
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/db_java_basic?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true
jdbc.username=root
jdbc.password=root
```
- 新建一个application.xml文件，开启注解扫描（项目包/数据库包），只要带注解都可以扫到，导入数据库的信息
- 使用bean配置数据源，开启数据源，配置jdbc模板
```$xslt
<context:property-placeholder location="db.properties"/>
    <bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource" init-method="init">
        <property name="driverClassName" value="${jdbc.driverClassName}"/>
        <property name="url" value="${jdbc.url}"/>
        <property name="username" value="${jdbc.username}"/>
        <property name="password" value="${jdbc.password}"/>
        <property name="initialSize" value="8"/>
    </bean>
    <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
        <property name="dataSource" ref="dataSource"/>
    </bean>
```