package com.tzashinorpu.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class TaskApplicationTests {


    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知-今晚开会");
        message.setText("今晚7:30开会");

        message.setTo("395747406@qq.com");
        message.setFrom("yzsnuaa@126.com");

        mailSender.send(message);
    }

    @Test
    public void test02() throws Exception {
        //1、创建一个复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("通知-今晚开会");
        helper.setText("<b style='color:red'>今天 7:30 开会</b>", true);

        helper.setTo("395747406@qq.com");
        helper.setFrom("yzsnuaa@126.com");

        //上传文件
        helper.addAttachment("1.jpg", new File("D:\\233333\\1.png"));
        helper.addAttachment("2.jpg", new File("D:\\233333\\thread_17557605_20160904220654_s_30737_2095005694.png"));

        mailSender.send(mimeMessage);

    }


}
