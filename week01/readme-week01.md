# Week01 作业题目

1.（选做）自己写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码，有问题群里讨论。

2.（必做）自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 Hello 方法，此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件。文件在我的教室下载。
> - 解答：
> https://github.com/Amy-Dai/Geekbang-Homework-JAVA-2022/blob/master/week01/Q2/MyJAVA/src/main/java/org/example/HelloClassLoader.java

> ![image](https://user-images.githubusercontent.com/56108927/166718976-7b7ff900-d990-43cf-aa1c-596a6e6062aa.png)


3.（必做）画一张图，展示 Xmx、Xms、Xmn、Meta、DirectMemory、Xss 这些内存参数的关系。
> - 解答：
> ![JVM内存启动参数 (1)](https://user-images.githubusercontent.com/56108927/167284664-0f8dd68f-993b-4681-9740-11d56f255043.jpg)


> ## [Survivor Space Sizing](https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/sizing.html#sthref22)
> The following are general guidelines for server applications:

> - First decide the maximum heap size you can afford to give the virtual machine. Then plot your performance metric against young generation sizes to find the best setting.
> 
> - Note that the maximum heap size should always be smaller than the amount of memory installed on the machine to avoid excessive page faults and thrashing.
> 
> - If the total heap size is fixed, then increasing the young generation size requires reducing the tenured generation size. Keep the tenured generation large enough to hold all the live data used by the application at any given time, plus some amount of slack space (10 to 20% or more).
> 
> - Subject to the previously stated constraint on the tenured generation:
> 
> - Grant plenty of memory to the young generation.
> 
> - Increase the young generation size as you increase the number of processors, because allocation can be parallelized.

> 参考资料：
> [JAVA8官方文档](https://docs.oracle.com/javase/8/)
> [JVM8 Specification](https://docs.oracle.com/javase/specs/jvms/se8/html/index.html)
> [JVM内存调优官方指南](https://docs.oracle.com/javase/8/docs/technotes/guides/vm/gctuning/sizing.html#sthref22)

4.（选做）检查一下自己维护的业务系统的 JVM 参数配置，用 jstat 和 jstack、jmap 查看一下详情，并且自己独立分析一下大概情况，思考有没有不合理的地方，如何改进。

注意：如果没有线上系统，可以自己 run 一个 web/java 项目。

5.（选做）本机使用 G1 GC 启动一个程序，仿照课上案例分析一下 JVM 情况。
