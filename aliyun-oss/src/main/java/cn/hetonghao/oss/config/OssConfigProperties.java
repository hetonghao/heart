package cn.hetonghao.oss.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * oss配置属性
 *
 * @author HeTongHao
 * @since 2020/4/12 14:35
 */
@Data
@ConfigurationProperties(prefix = "oss.aliyun")
public class OssConfigProperties {
    private String imagesHost;
    /**
     * 地域节点
     */
    private String endPoint;
    private String bucket;
    private String accessKeyId;
    private String accessKeySecret;
}
