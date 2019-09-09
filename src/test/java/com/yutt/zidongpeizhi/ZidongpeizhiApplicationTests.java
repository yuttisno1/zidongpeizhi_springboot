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
//��¼��
    @Test
    public void contextLoads_1() {
        t.trace("����trace��־-------");
        t.debug("����debug��־-------");
        t.info("����info��־-------");
        t.warn("����warn��־-----");
        t.error("����error��־----");
    }
    @Test
public void he()
{
    //System.out.println("��Һ�");

   // ManyThreadDao.thread_longzhu(5);
   // System.out.println("hello ���Ǻ�");
    System.out.println("��Һ�");
    ZidongpeizhiApplicationTests.thread_longzhu(5);
}

    public static Map thread_longzhu(int longzhu)
    {
        Map map=new HashMap();
        CyclicBarrier cb=new CyclicBarrier(7,()->{
            System.out.println("�ٻ�����");
        });
        for (int i = 1; i <=longzhu ; i++) {
            final int n=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t �ռ�����"+n+"�����顣");
                //blockingQueue.offer(Thread.currentThread().getName()+"\t �ռ�����"+n+"�����顣");
                String a=Thread.currentThread().getName()+"\t �ռ�����"+n+"�����顣";
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
