package cn.hetonghao.heart.edu.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.hetonghao.heart.edu.service.ISubjectService;
import cn.hetonghao.heart.edu.entity.Subject;
import cn.hetonghao.heart.edu.vo.SubjectPageVO;
import cn.hetonghao.heart.edu.bo.SubjectBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-13
 */
@Api(tags = {"课程科目"})
@RestController
@RequestMapping("subjects")
public class SubjectController {
    @Autowired
    private ISubjectService subjectService;

    @PostMapping
    @ApiOperation(value = "列表", notes = "所有数据列表查询,传入pageNumber与pageSize可分页")
    public IPage<SubjectBO> page(@RequestBody SubjectPageVO vo) {
        IPage page = vo.generatePage();
        subjectService.page(page, vo);
        return page;
    }

    @GetMapping("tree")
    @ApiOperation(value = "tree", notes = "树形列表")
    public List<SubjectBO> tree() {
        return subjectService.tree();
    }

    @GetMapping("{id}")
    @ApiOperation(value = "根据id查询")
    public SubjectBO detail(@PathVariable("id") String id) {
        return subjectService.findDetail(id);
    }

    @PatchMapping
    @ApiOperation(value = "新增或更新", notes = "新增或更新，id is null新增数据，id not null更新数据")
    public SubjectBO saveOrUpdate(@RequestBody @Valid Subject subject) {
        subjectService.saveData(subject);
        return detail(subject.getId());
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "删除")
    public void delete(@PathVariable("id") String id) {
        subjectService.delete(id);
    }
}
