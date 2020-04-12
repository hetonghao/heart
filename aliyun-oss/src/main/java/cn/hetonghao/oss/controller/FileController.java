package cn.hetonghao.oss.controller;

import cn.hetonghao.oss.service.IOssFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vc.thinker.common.response.SingleResponse;

/**
 * 文件管理Controller
 *
 * @author HeTongHao
 * @since 2020/4/12 15:15
 */
@Api("文件管理")
@RestController
@RequestMapping("file")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FileController {
    @Autowired
    private IOssFileService ossFileService;

    @ApiOperation("文件上传")
    @PostMapping("upload")
    public SingleResponse<String> upload(@RequestParam MultipartFile file) {
        return new SingleResponse<String>()
                .setData(ossFileService.upload(file));
    }
}
