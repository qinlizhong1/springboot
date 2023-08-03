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


#### redisTemplate
使用redisTemplate该类可以存放任意类型的数据，但是该类型的数据必须实现序列，
获取redis中对应的数据时，会进行反序列化。 如果使用RedisTemplate建议大家指定key，
value，以及hashkey的序列化方式。