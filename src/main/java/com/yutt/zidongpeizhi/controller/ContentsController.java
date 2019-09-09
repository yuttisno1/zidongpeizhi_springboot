package com.yutt.zidongpeizhi.controller;

import com.yutt.zidongpeizhi.dao.ManyThreadDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ContentsController {

    @RequestMapping("/contents")
    public String contents()
    {
        return "contents";
    }
    @RequestMapping("/chat")
    public String caht()
    {
        return "chat";
    }

    @RequestMapping("/lookme")
    public String index(){
        return "lookme";
    }
    @RequestMapping("/chat2")
    public String caht2()
    {
        return "chat2";
    }
    @RequestMapping("/chat3")
    public String caht3()
    {
        return "chat3";
    }
    @RequestMapping("/chat00")
    public String caht00()
    {
        return "chat00";
    }

    @RequestMapping("/ManyThread")
    public String ManyThread()
    {
        return "ManyThread";
    }

    @RequestMapping("/lianxi_0902")
    public String lianxi_0902()
    {
        return "lianxi_0902";
    }
}
