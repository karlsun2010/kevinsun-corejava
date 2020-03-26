分布式消息队列

kafka集群  强依赖zookeeper



Producer使用push模式将消息发布到broker，
Consumer使用pull模式从broker订阅并消费消息。

kafka的快：
1  顺序读写
2  零拷贝机制

分区策略：
1 顺序轮询
2 随机轮询
3 key hash


acks 设置消息可靠性

消费者Rebalance，增加或者减少消费者组中的消费者时，会发生重平衡。


保证数据不丢失。
Producer send后回调，以及消息重发机制。
Consumer 手动提交offset

kafka中的控制器






kafka HW（高水位）
1 定义消息可见性，分区下那些消息可以被消费者消费的。





