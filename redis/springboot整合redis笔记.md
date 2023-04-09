#### springboot整合redis
1. pom.xml加入依赖
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

2. 在application.properties中加入redis相关配置

3. 注入StringRedisTemplate或RedisTemplate