package cn.hetonghao.heart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HeTongHao
 * @since 2020/3/17 23:43
 */
@MapperScan("cn.hetonghao.**.mapper")
@SpringBootApplication(scanBasePackages = "cn.hetonghao")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
