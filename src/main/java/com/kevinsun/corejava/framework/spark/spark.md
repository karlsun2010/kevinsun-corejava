spark submit提交任务，通过反射调用用户代码Main,
DAGShaudler，TaskShaduler。
Driver 提交任务到Executor ，执行Task。

spark任务调优：






状态管理：updatestatebykey



spark streaming 集成kafka

Direct 模式：
1 Dstream 每个分区和kafka patition 一一对应
2 offsets保存在spark的checkpoints中

