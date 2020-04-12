package cn.hetonghao.oss.service.impl;

import cn.hetonghao.oss.config.OssConfigProperties;
import cn.hetonghao.oss.service.IOssFileService;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;

/**
 * oss 文件管理实现
 *
 * @author HeTongHao
 * @since 2020/4/12 14:34
 */
@Service
@EnableConfigurationProperties(OssConfigProperties.class)
public class OssFileServiceImpl implements IOssFileService {
    @Autowired
    private OssConfigProperties ossConfigProperties;

    /**
     * 创建OSSClient实例
     *
     * @return
     */
    private OSS createOssClient() {
        return new OSSClientBuilder().build(ossConfigProperties.getEndPoint()
                , ossConfigProperties.getAccessKeyId(), ossConfigProperties.getAccessKeySecret());
    }

    @Override
    public String upload(MultipartFile multipartFile) {
        String uploadPath = null;
        OSS ossClient = null;
        try {
            // 创建OSSClient实例。
            ossClient = createOssClient();
            // 对文件重命名
            String oriName = Optional.ofNullable(multipartFile.getOriginalFilename()).orElse("");
            // 文件按日期分类
            String filePath = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDate.now());
            String fileName = UUID.randomUUID().toString();
            String fileSuffix = oriName.substring(oriName.indexOf("."));
            String fileNewName = fileName + fileSuffix;
            String fileUrl = ossConfigProperties.getImagesHost() + '/' + filePath + '/' + fileNewName;
            // 上传一个对象
            ossClient.putObject(ossConfigProperties.getBucket(), fileUrl, multipartFile.getInputStream());
            // 最后的访问路径 = Bucket+EndPoint+fileFullUrl
            uploadPath = "https://" + ossConfigProperties.getBucket() + "." + ossConfigProperties.getEndPoint()
                    + "/" + fileUrl;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ossClient != null) {
                // 关闭OSSClient。
                ossClient.shutdown();
            }
        }
        return uploadPath;
    }

    @Override
    public Bucket createBucket(String bucketName) {
        Bucket bucket;
        OSS ossClient = null;
        try {
            // 创建OSSClient实例。
            ossClient = createOssClient();
            CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
            //设置成公共读
            createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
            //创建
            bucket = ossClient.createBucket(createBucketRequest);
        } finally {
            if (ossClient != null) {
                // 关闭OSSClient。
                ossClient.shutdown();
            }
        }
        return bucket;
    }
}
