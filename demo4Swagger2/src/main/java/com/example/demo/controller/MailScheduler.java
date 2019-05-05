package com.example.demo.controller;


import org.springframework.stereotype.Controller;

@Controller
public class MailScheduler {

  /*  @Autowired
    private BugNotify bugNotify;

    @Autowired
    private MailService mailService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Scheduled(cron = "0 0/15 * * * ?")   //每15分钟触发一次
    public void doTask() {
        System.out.println("执行了MyStaticTask,时间为:" + new Date(System.currentTimeMillis()));
        List<BugNotifyBean> lists = bugNotify.BugNotify();

        Iterator it = lists.iterator();
        while (it.hasNext()) {

            BugNotifyBean bugNotifyBean = (BugNotifyBean) it.next();


            String aaa = bugNotifyBean.getDeveloperEmail();
            String bbb = bugNotifyBean.getTesterEmail();


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

    }*/
}
