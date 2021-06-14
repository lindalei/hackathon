package com.demo.hackthon;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class HackthonApplicationTests {
		@Autowired
		private JavaMailSender mailSender;

		@Test
		public void sendSimpleMail() throws Exception {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("1019362617@qq.com");
			message.setTo("1019362617@qq.com");
			message.setSubject("主题：简单测试邮件");
			message.setText("测试邮件内容");
			mailSender.send(message);
		}

	}


