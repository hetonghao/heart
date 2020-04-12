package cn.hetonghao.oss;

import cn.hetonghao.mybatisplus.start.MybatisPlusConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author HeTongHao
 * @since 2020/4/12 15:20
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MybatisPlusConfig.class})
public class OssServerMain {
    public static void main(String[] args) {
        SpringApplication.run(OssServerMain.class, args);
    }
}
