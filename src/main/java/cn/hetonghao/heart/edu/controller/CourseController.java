package cn.hetonghao.heart.edu.controller;

import cn.hetonghao.heart.edu.bo.CourseBO;
import cn.hetonghao.heart.edu.service.ICourseService;
import cn.hetonghao.heart.edu.vo.CoursePageVO;
import cn.hetonghao.heart.edu.vo.api.CourseSaveVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-16
 */
@Api(tags = {"课程"})
@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @PostMapping
    @ApiOperation(value = "列表", notes = "所有数据列表查询,传入pageNumber与pageSize可分页")
    public IPage<CourseBO> page(@RequestBody CoursePageVO vo) {
        IPage page = vo.generatePage();
        courseService.page(page, vo);
        return page;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "根据id查询")
    public CourseBO detail(@PathVariable("id") String id) {
        return courseService.findDetail(id);
    }

    @PatchMapping
    @ApiOperation(value = "新增或更新", notes = "新增或更新，id is null新增数据，id not null更新数据")
    public CourseBO saveOrUpdate(@RequestBody @Valid CourseSaveVO course) {
        courseService.saveData(course);
        return detail(course.getId());
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable("id") String id) {
        courseService.delete(id);
    }
}
