package cn.hetonghao.oss;

import cn.hetonghao.oss.service.IOssFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author HeTongHao
 * @since 2020/4/12 16:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OssServerMain.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OssTest {
    @Autowired
    private IOssFileService ossFileService;

    @Test
    public void testCreateBucket() {
        System.out.println(ossFileService.createBucket("hetonghao-test-bucket"));
    }
}
