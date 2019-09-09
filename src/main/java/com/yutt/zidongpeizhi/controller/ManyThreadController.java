package com.yutt.zidongpeizhi.controller;

import com.yutt.zidongpeizhi.dao.ManyThreadDao;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Controller
public class ManyThreadController {

    @PostMapping(value="ManyThread")
    public String ManyThread(
            @RequestParam("num") Integer num,
            Map<String,Object> map, HttpSession session){
        System.out.println(num);
        if(!StringUtils.isEmpty(num))
        {
            session.setAttribute("num",num);
            Map mmap=ManyThreadDao.thread_longzhu(num);
            map.put("num",num);
            map.put("liebiao",mmap);
            return "ManyThread";
        }
        else{
            map.put("msg","请输入参数");
            return "redirect:/ManyThread.html";
        }
    }

//    public String ManyThread(
//            @RequestParam("num") Integer num,
//            Map<String,Object> map, HttpSession session){
//        int corePoolSize;
//        int maximum;
//        int queue;
//        int yewu;
//        System.out.println(num);
//        if(!StringUtils.isEmpty(num))
//        {
//         //   session.setAttribute("num",num);
//
//            ManyThreadDao.bankPoolThread(corePoolSize,maximum, queue,yewu);
//            map.put("num",num);
//           // map.put("liebiao",mmap);
//            return "ManyThread";
//        }
//        else{
//            map.put("msg","请输入参数");
//            return "redirect:/ManyThread.html";
//        }
//    }
    

//


//    @RequestMapping("/longzhu")
//    public String longzhu(Map<String,Object> map){
//        Map mmap=new HashMap();
//        mmap.put("a","a");
//        mmap.put("b","b");
//        mmap.put("c","c");
//        mmap.put("d","d");
//        map.put("liebiao", mmap);
//        return "ManyThread/longzhu";
//    }

//    @RequestMapping("/success")
//    public String success(Map<String,Object> map){
//        //templates/success.html
//        map.put("hello","<h1>你好！</h1>");
//        map.put("users", Arrays.asList("张三","李四","王五","赵柳"));
//        return "success";
//    }

//    @PostMapping(value="ManyThread")
//    public String ManyThread(
//            @RequestParam("num") Integer num,
//            Map<String,Object> map, HttpSession session){
//        System.out.println(num);
//        if(!StringUtils.isEmpty(num))
//        {
//            session.setAttribute("num",num);
//            Map mmap=ManyThreadDao.thread_longzhu(num);
//            map.put("liebiao",mmap);
//            return "ManyThread/longzhu";
//        }
//        else{
//            map.put("msg","请输入参数");
//            return "redirect:/ManyThread.html";
//        }
//    }

}
