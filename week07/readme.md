# 1.（选做）用今天课上学习的知识，分析自己系统的 SQL 和表结构
# 2.（必做）按自己设计的表结构，插入 100 万订单模拟数据，测试不同方式的插入效率

## 测试方式
### 一种是关闭自动提交，一百万的数据弄好后一起提交
    completed in 2 m 29 s 195 ms
### 一种是一条一条的提交插入
    太久略过不提了
### 代码

https://github.com/Amy-Dai/Geekbang-Homework-JAVA-2022/blob/master/week07/Q2/TestInsert.sql


# 3.（选做）按自己设计的表结构，插入 1000 万订单模拟数据，测试不同方式的插入效
# 4.（选做）使用不同的索引或组合，测试不同方式查询效率
# 5.（选做）调整测试数据，使得数据尽量均匀，模拟 1 年时间内的交易，计算一年的销售报表：销售总额，订单数，客单价，每月销售量，前十的商品等等（可以自己设计更多指标）
# 6.（选做）尝试自己做一个 ID 生成器（可以模拟 Seq 或 Snowflake）
# 7.（选做）尝试实现或改造一个非精确分页的程序

# 8.（选做）配置一遍异步复制，半同步复制、组复制
# 9.（必做）读写分离 - 动态切换数据源版本 1.0

https://github.com/Amy-Dai/Geekbang-Homework-JAVA-2022/tree/master/week07/DB/src/main/java/com/example/DB

# 10.（必做）读写分离 - 数据库框架版本 2.0

https://github.com/Amy-Dai/Geekbang-Homework-JAVA-2022/tree/master/week07/DB/src/main/java/com/example/shardingsphere/raw/jdbc

# 11.（选做）读写分离 - 数据库中间件版本 3.0
# 12.（选做）配置 MHA，模拟 master 宕机
# 13.（选做）配置 MGR，模拟 master 宕机
# 14.（选做）配置 Orchestrator，模拟 master 宕机，演练 UI 调整拓扑结构
