package com.example.demo;

import com.example.demo.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSendSimpleMail() throws Exception {
        mailService.sendSimpleMail("jasqia@acxiom.com", "测试发送简单文本邮件", "测试发送简单文本邮件");
    }

    @Test
    public void testSendTemplateMail() {
        Context context = new Context();
        context.setVariable("username", "夏天里的Jasmine");
        String emailContent = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail("jasqia@acxiom.com", "欢迎您加入博客园", emailContent);
    }


}

