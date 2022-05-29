package com.example.concurrency;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class Homework {
    public static void main(String[] args) {

        long start=System.currentTimeMillis();

        // 在这里创建一个线程或线程池，
        // 异步执行 下面方法
        Callable<Integer> callable = new Callable<>() {
            @Override
            public Integer call() throws Exception {
                return sum();
            }
        };
        FutureTask<Integer> func1 = new FutureTask<>(callable);
        new Thread(func1).start();
        int result = 0;
        try {
            result = func1.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

//        int result = sum(); //这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("Method-1：FutureTask异步计算结果为："+result);
        System.out.println("Method-1：FutureTask使用时间："+ (System.currentTimeMillis()-start) + " ms");

        start = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        Future<Integer> poolFuture = threadPool.submit(callable);
        try {
            result = poolFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // 确保  拿到result 并输出
        System.out.println("Method-2，Threadpool Future异步计算结果为："+result);
        System.out.println("Method-2，Threadpool Future使用时间："+ (System.currentTimeMillis()-start) + " ms");

        start = System.currentTimeMillis();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return sum();
            }
        }, threadPool);
        try {
            completableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Method-3，CompletableFuture异步计算结果为："+result);
        System.out.println("Method-3，CompletableFuture使用时间："+ (System.currentTimeMillis()-start) + " ms");

        // 然后退出main线程
        System.exit(0);
    }

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if ( a < 2)
            return 1;
        return fibo(a-1) + fibo(a-2);
    }
}
