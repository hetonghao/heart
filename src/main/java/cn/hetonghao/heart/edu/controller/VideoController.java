package cn.hetonghao.heart.edu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.hetonghao.heart.edu.service.IVideoService;
import cn.hetonghao.heart.edu.entity.Video;
import cn.hetonghao.heart.edu.vo.VideoPageVO;
import cn.hetonghao.heart.edu.bo.VideoBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-19
 */
@Api(tags = {"课程视频"})
@RestController
@RequestMapping("video")
public class VideoController {
    @Autowired
    private IVideoService videoService;

    @PostMapping
    @ApiOperation(value = "列表", notes = "所有数据列表查询,传入pageNumber与pageSize可分页")
    public IPage<VideoBO> page(@RequestBody VideoPageVO vo) {
        IPage page = vo.generatePage();
        videoService.page(page, vo);
        return page;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "根据id查询")
    public VideoBO detail(@PathVariable("id") String id) {
        return videoService.findDetail(id);
    }

    @PatchMapping
    @ApiOperation(value = "新增或更新", notes = "新增或更新，id is null新增数据，id not null更新数据")
    public VideoBO saveOrUpdate(@RequestBody @Valid Video video) {
        videoService.saveData(video);
        return detail(video.getId());
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable("id") String id) {
        videoService.delete(id);
    }
}
