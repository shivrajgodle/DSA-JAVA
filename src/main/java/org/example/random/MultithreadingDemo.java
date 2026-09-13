package org.example.random;

import java.util.concurrent.*;
/**
Common Concurrency tools in Java :
ExecutorService:
An ExecutorService is a utility in Java that provides a way to execute tasks concurrently.

It manages a pool of worker threads, and allows you to submit tasks for execution.
The ExecutorService handles creation, management, and reusability of threads, making it
 easier to handle concurrent tasks in multithreaded applications.
**/

public class MultithreadingDemo {

    public static void performExecutorServiceExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(()->{
            System.out.println("Task 1 is executing");
        });

        executorService.submit(()->{
            System.out.println("Task 2 is executing");
        });

        executorService.shutdown();
    }

    public static void performExecutorServiceExampleUsingFuture() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // Submit a task and obtain a Future object
        Future<String> future = executorService.submit(()->{
                Thread.sleep(2000);
                return "Hello Shivraj, I am from future";
        });

        // Perform other tasks while the computation is in progress

        // Wait for the result and retrieve it
        String result = future.get();
        System.out.println(result);
        executorService.shutdown();
    }

    public static void performExecutorServiceExampleUsingCallable() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submit a task and obtain a Future object
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 42;
            }
        });

        // Perform other tasks while the computation is in progress

        // Wait for the result and retrieve it
        Integer result = future.get();
        System.out.println(result);
        executorService.shutdown();
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {


        // Example of using a ExecutorService:
        //performExecutorServiceExample();

        //Example of using Future:
        //performExecutorServiceExampleUsingFuture();

        //Example of using Callable::

        // The Callable interface is similar to the Runnable interface but represents a task that returns a result.
        // It is used in conjunction with the ExecutorService and Future to execute tasks asynchronously and obtain their results.
        performExecutorServiceExampleUsingCallable();


    }
}
