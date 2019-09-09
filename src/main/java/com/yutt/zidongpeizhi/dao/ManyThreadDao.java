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
        System.out.println("�ٻ�����");
        map.put("sum","���ڼ���7�ţ������ٻ�������");
    });
    for (int i = 1; i <=longzhu ; i++) {
        final int n=i;
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t �ռ�����"+n+"�����顣");
            //blockingQueue.offer(Thread.currentThread().getName()+"\t �ռ�����"+n+"�����顣");
            String a="�ռ�����"+n+"�����顣";
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
    //��д�̳߳� һ��������ڣ�Ĭ�Ͽ���2�����ڣ��Ⱥ�����������λ��10��ҵ��
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
                System.out.println(Thread.currentThread().getName()+"\t ����ҵ��");
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
