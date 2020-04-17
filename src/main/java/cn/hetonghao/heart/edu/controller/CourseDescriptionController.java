package cn.hetonghao.heart.edu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.hetonghao.heart.edu.service.ICourseDescriptionService;
import cn.hetonghao.heart.edu.entity.CourseDescription;
import cn.hetonghao.heart.edu.vo.CourseDescriptionPageVO;
import cn.hetonghao.heart.edu.bo.CourseDescriptionBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 课程简介 前端控制器
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-16
 */
@Api(tags = {"课程简介"})
@RestController
@RequestMapping("course-description")
public class CourseDescriptionController {
    @Autowired
    private ICourseDescriptionService courseDescriptionService;

    @PostMapping
    @ApiOperation(value = "列表", notes = "所有数据列表查询,传入pageNumber与pageSize可分页")
    public IPage<CourseDescriptionBO> page(@RequestBody CourseDescriptionPageVO vo) {
        IPage page = vo.generatePage();
        courseDescriptionService.page(page, vo);
        return page;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "根据id查询")
    public CourseDescriptionBO detail(@PathVariable("id") String id) {
        return courseDescriptionService.findDetail(id);
    }

    @PatchMapping
    @ApiOperation(value = "新增或更新", notes = "新增或更新，id is null新增数据，id not null更新数据")
    public CourseDescriptionBO saveOrUpdate(@RequestBody @Valid CourseDescription courseDescription) {
        courseDescriptionService.saveData(courseDescription);
        return detail(courseDescription.getId());
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable("id") String id) {
        courseDescriptionService.delete(id);
    }
}
