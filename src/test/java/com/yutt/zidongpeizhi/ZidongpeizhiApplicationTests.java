package com.yutt.zidongpeizhi;

import com.yutt.zidongpeizhi.dao.ManyThreadDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZidongpeizhiApplicationTests {

    @Autowired
    DataSource dataSource;
    @Test
    public void contextLoads()throws SQLException {

        System.out.println("the first:"+dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println("second:"+connection);

    }
    @Test
public void ceshi()
{
    Map mmap= thread_longzhu(5);

}
    Logger t= LoggerFactory.getLogger(getClass());
//记录器
    @Test
    public void contextLoads_1() {
        t.trace("这是trace日志-------");
        t.debug("这是debug日志-------");
        t.info("这是info日志-------");
        t.warn("这是warn日志-----");
        t.error("这是error日志----");
    }
    @Test
public void he()
{
    //System.out.println("大家好");

   // ManyThreadDao.thread_longzhu(5);
   // System.out.println("hello 你们好");
    System.out.println("大家好");
    ZidongpeizhiApplicationTests.thread_longzhu(5);
}

    public static Map thread_longzhu(int longzhu)
    {
        Map map=new HashMap();
        CyclicBarrier cb=new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });
        for (int i = 1; i <=longzhu ; i++) {
            final int n=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 收集到第"+n+"颗龙珠。");
                //blockingQueue.offer(Thread.currentThread().getName()+"\t 收集到第"+n+"颗龙珠。");
                String a=Thread.currentThread().getName()+"\t 收集到第"+n+"颗龙珠。";
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

}
