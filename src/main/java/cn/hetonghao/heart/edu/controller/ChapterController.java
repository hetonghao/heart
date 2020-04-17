package cn.hetonghao.heart.edu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.hetonghao.heart.edu.service.IChapterService;
import cn.hetonghao.heart.edu.entity.Chapter;
import cn.hetonghao.heart.edu.vo.ChapterPageVO;
import cn.hetonghao.heart.edu.bo.ChapterBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 章节 前端控制器
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-16
 */
@Api(tags = {"章节"})
@RestController
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private IChapterService chapterService;

    @PostMapping
    @ApiOperation(value = "列表", notes = "所有数据列表查询,传入pageNumber与pageSize可分页")
    public IPage<ChapterBO> page(@RequestBody ChapterPageVO vo) {
        IPage page = vo.generatePage();
        chapterService.page(page, vo);
        return page;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "根据id查询")
    public ChapterBO detail(@PathVariable("id") String id) {
        return chapterService.findDetail(id);
    }

    @PatchMapping
    @ApiOperation(value = "新增或更新", notes = "新增或更新，id is null新增数据，id not null更新数据")
    public ChapterBO saveOrUpdate(@RequestBody @Valid Chapter chapter) {
        chapterService.saveData(chapter);
        return detail(chapter.getId());
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable("id") String id) {
        chapterService.delete(id);
    }
}
