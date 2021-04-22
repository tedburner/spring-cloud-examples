# spring-cloud-examples
Spring Cloud 整合项目


## TODO List

* [x] Spring Cloud Config
* [x] Spring Cloud Eureka Server 注册中心
* [ ] Spring Cloud Gateway 网关
* [ ] Spring Cloud Sleuth + Zipkin 分布式链路跟踪
* [ ] Docker Compose
* [x] 基于RocketMq的分布式事务
--- 

## 目录结构
- [注册中心](registry)
- [配置中心](config)
- [网关](gateway)

## 分布式链路跟踪 Sleuth 与 Zipkin
### 安装 Zipkin
zipkin 在2.0之后，不推荐自己搭建服务，直接使用官方编译包部署
```bash
# 方法一：启动jar
curl -sSL https://zipkin.io/quickstart.sh | bash -s
java -jar zipkin.jar

# 方法二：使用docker部署
docker pull openzipkin/zipkin
docker run -d --name zipkin -p 9411:9411 openzipkin/zipkin 
```

## 启动 Seata 
### 准备工作
1. 执行sql/all_in_one.sql

2. 下载[0.6.1](https://github.com/seata/seata/releases/tag/0.6.1)版本server

   客户端与服务端版本号保持一致
3. 启动seata server

   sh seata-server.sh 8091 ../data/
4. 启动business、storage、account、order

   数据库默认连接127.0.0.1:3306，不同的注意修改

5. 事务成功 GET http://127.0.0.1:8084/purchase/commit

6. 事务回滚 GET http://127.0.0.1:8084/purchase/rollback

### 验证数据
1. 事务成功

   库存减1、订单加1、余额减5
2. 事务回滚

   数据无变化