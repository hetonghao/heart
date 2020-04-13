package cn.hetonghao.heart;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author HeTongHao
 * @since 2020/3/17 23:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Main1 {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Test
    public void sendEmail() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("测试");
        simpleMailMessage.setText("明天不上班");
        simpleMailMessage.setTo("1216040658@qq.com", "hth0406@163.com");
        simpleMailMessage.setFrom("1216040658@qq.com");
        javaMailSender.send(simpleMailMessage);
    }

    @Test
    public void sendEmail2() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setSubject("复杂邮件测试测试");
        mimeMessageHelper.setText("<h2>明天不上班喽</h2>", true);
        String[] tos = {"1216040658@qq.com", "hth0406@163.com"};
        mimeMessageHelper.setTo(tos);
        mimeMessageHelper.setFrom("1216040658@qq.com");
        mimeMessageHelper.addAttachment("技术人员成长规划.pdf", new File("/Users/HTH/Downloads/技术人员成长规划.pdf"));
        javaMailSender.send(mimeMessage);
    }
}
