package com.example.demo.controller;


import com.example.demo.email.BugNotify;
import com.example.demo.email.BugNotifyBean;
import com.example.demo.email.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class MailScheduler {

    @Autowired
    private BugNotify bugNotify;

    @Autowired
    private MailService mailService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Scheduled(cron = "* 15 * * * ?")
    //@Scheduled(cron = "1/2 * * * * ?")
    public void doTask() {
        System.out.println("执行了MyStaticTask,时间为:" + new Date(System.currentTimeMillis()));
        List<BugNotifyBean> lists = bugNotify.BugNotify();

        Iterator it = lists.iterator();
        while (it.hasNext()) {

            BugNotifyBean bugNotifyBean = (BugNotifyBean) it.next();


            String aaa = bugNotifyBean.getDeveloperEmail();
            String bbb = bugNotifyBean.getTesterEmail();
            String recep =aaa+","+bbb;


            Context context = new Context();
            context.setVariable("bugdes", bugNotifyBean.getDescription());
            context.setVariable("bugstatus", bugNotifyBean.getBugStatus());
            context.setVariable("crname", bugNotifyBean.getCrname());
            context.setVariable("crnum", bugNotifyBean.getCrnum());
            context.setVariable("oname", bugNotifyBean.getOname());
            context.setVariable("pname", bugNotifyBean.getPname());
            context.setVariable("rca", bugNotifyBean.getRca());
            context.setVariable("tasknum", bugNotifyBean.getTasknum());
            context.setVariable("solution", bugNotifyBean.getSolution());


            String emailContent = templateEngine.process("emailTemplate", context);
            mailService.sendHtmlMail(aaa, bbb,"您好，有一个Bug要关注，谢谢!!", emailContent);

        }

    }
}
