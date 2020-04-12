package cn.hetonghao.heart.edu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.hetonghao.heart.edu.service.ITeacherService;
import cn.hetonghao.heart.edu.entity.Teacher;
import cn.hetonghao.heart.edu.vo.TeacherPageVO;
import cn.hetonghao.heart.edu.bo.TeacherBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-09
 */
@Api(tags = {"讲师"})
@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;

    @PostMapping
    @ApiOperation(value = "列表", notes = "所有数据列表查询,传入pageNumber与pageSize可分页")
    public IPage<TeacherBO> page(@RequestBody TeacherPageVO vo) {
        IPage page = vo.generatePage();
        teacherService.page(page, vo);
        return page;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "根据id查询")
    public TeacherBO detail(@PathVariable("id") String id) {
        return teacherService.findDetail(id);
    }

    @PatchMapping
    @ApiOperation(value = "新增或更新", notes = "新增或更新，id is null新增数据，id not null更新数据")
    public TeacherBO saveOrUpdate(@RequestBody @Valid Teacher teacher) {
        teacherService.saveData(teacher);
        return detail(teacher.getId());
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable("id") String id) {
        teacherService.delete(id);
    }
}
