# product-shopping-cart
springboot + springcloud项目：分布式，一个简单的购物车项目，使用到mongodb的，MySQL和redis的（redistemplate），RabbitMQ的。
先启动eureka注册中心，让其余服务可以在后续启动时可以找到注册中心，并且将服务注册上去，webapp是作为消费者一段进行访问

## springCloud
项目中通过该springCloud中的注册中心Eureka来管理各个服务，让各个服务之间都可以通过Eureka来进行调用
## mongodb
项目中通过mongodb来进行日志的记录，记录中包含用户的ip，id，时间以及访问的方法等等。
## redis
通过redis来实习缓存的效果，并将用户添加到购物车中的商品通过redis进行保留，从而减少与数据库的访问。
