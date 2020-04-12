package cn.hetonghao.oss.service;

import com.aliyun.oss.model.Bucket;
import org.springframework.web.multipart.MultipartFile;

/**
 * oss 文件管理
 *
 * @author HeTongHao
 * @since 2020/4/12 14:32
 */
public interface IOssFileService {
    /**
     * 上传文件
     *
     * @param multipartFile
     * @return
     */
    String upload(MultipartFile multipartFile);

    /**
     * 创建Bucket
     *
     * @param bucketName
     * @return
     */
    Bucket createBucket(String bucketName);
}
