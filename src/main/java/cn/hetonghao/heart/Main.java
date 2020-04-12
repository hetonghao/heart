package cn.hetonghao.heart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import vc.thinker.config.ApiConfig;

/**
 * @author HeTongHao
 * @since 2020/3/17 23:43
 */
@SpringBootApplication(exclude = {ApiConfig.class})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
