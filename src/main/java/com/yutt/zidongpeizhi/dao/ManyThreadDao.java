package com.yutt.zidongpeizhi.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

@Repository
public class ManyThreadDao {
public static Map thread_longzhu(int longzhu)
{
    Map map=new HashMap();
    CyclicBarrier cb=new CyclicBarrier(7,()->{
        System.out.println("召唤神龙");
        map.put("sum","终于集齐7颗，可以召唤神龙了");
    });
    for (int i = 1; i <=longzhu ; i++) {
        final int n=i;
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t 收集到第"+n+"颗龙珠。");
            //blockingQueue.offer(Thread.currentThread().getName()+"\t 收集到第"+n+"颗龙珠。");
            String a="收集到第"+n+"颗龙珠。";
            map.put(n,a);
            try
            {cb.await();}
            catch (InterruptedException e)
            {e.printStackTrace();}
            catch (BrokenBarrierException e)
            {e.printStackTrace();}
        },String.valueOf(i)).start();
    }
    return map;
}
public static Map bankPoolThread(int corePoolSize,int maximum,int queue,int yewu)
{
    Map map=new HashMap();
    //自写线程池 一共五个窗口，默认开启2个窗口，等候厅有三个座位，10个业务
    ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
            2,
            5,
            2L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(3),
            Executors.defaultThreadFactory(),
            // new ThreadPoolExecutor.AbortPolicy());
            // new ThreadPoolExecutor.CallerRunsPolicy());
            // new ThreadPoolExecutor.DiscardOldestPolicy());
            new ThreadPoolExecutor.DiscardPolicy());
    try{
        for (int i = 1; i <=10; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName()+"\t 办理业务");
            });
        }
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    finally {
        threadPoolExecutor.shutdown();
    }
    return map;
}
}
