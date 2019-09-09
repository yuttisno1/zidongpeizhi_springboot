package com.yutt.zidongpeizhi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @ResponseBody
    @GetMapping("/query")
    public Map<String,Object>map(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from department");
        return list.get(0);
    }


    //    @RequestMapping({"/","/login.html"})
//    public String login()
//    {
//        return "login";
//    }
    @RequestMapping("/hello")
    public String hello()
    {
        return "Hello world!";
    }
    //只要把HTML文件放到类路径下的tem
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        //templates/success.html
        map.put("hello","<h1>你好！</h1>");
        map.put("users", Arrays.asList("张三","李四","王五","赵柳"));
        return "success";
    }

}
