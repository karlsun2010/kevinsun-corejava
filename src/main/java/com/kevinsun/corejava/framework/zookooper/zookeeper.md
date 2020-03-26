zookeeper=文件系统+监听通知机制

四种节点类型：
1 临时节点
2 临时顺序节点
3 持久化节点
4 持久化顺序节点


Zab协议规定：来自Client的所有写请求，都要转发给ZK服务中唯一的Server—Leader，由Leader根据该请求发起一个Proposal（请求）。
然后，其他的Server对该Proposal（请求）进行Vote（投票）。
之后，Leader对Vote（投票）进行收集，当Vote数量过半时Leader会向所有的Server发送一个通知消息。
最后，当Client所连接的Server收到该消息时，会把该操作更新到内存中并对Client的写请求做出回应。


为了提升zookeeper集群的写吞吐量，引入了Observer节点，不参与投票，可以接受读请求，并转发写请求给leader节点。




Zab协议 的全称是 Zookeeper Atomic Broadcast （Zookeeper原子广播）。
Zookeeper 是通过 Zab 协议来保证分布式事务的最终一致性。

Zab 协议包括两种基本的模式：崩溃恢复 和 消息广播。


四、用CAP理论来分析ZooKeeper
CAP理论告诉我们，一个分布式系统不可能同时满足以下三种

一致性（C:Consistency）
可用性（A:Available）
分区容错性（P:Partition Tolerance）
这三个基本需求，最多只能同时满足其中的两项，因为P是必须的,因此往往选择就在CP或者AP中。

在此ZooKeeper保证的是CP

分析：可用性（A:Available）

不能保证每次服务请求的可用性。任何时刻对ZooKeeper的访问请求能得到一致的数据结果，同时系统对网络分割具备容错性；
但是它不能保证每次服务请求的可用性（注：也就是在极端环境下，ZooKeeper可能会丢弃一些请求，消费者程序需要重新请求才能获得结果）。
所以说，ZooKeeper不能保证服务可用性。
进行leader选举时集群都是不可用。在使用ZooKeeper获取服务列表时，当master节点因为网络故障与其他节点失去联系时，
剩余节点会重新进行leader选举。问题在于，选举leader的时间太长，30 ~ 120s, 且选举期间整个zk集群都是不可用的，
这就导致在选举期间注册服务瘫痪，虽然服务能够最终恢复，但是漫长的选举时间导致的注册长期不可用是不能容忍的。
所以说，ZooKeeper不能保证服务可用性。




zk开发框架 Curator，封装了底层api的复杂性。