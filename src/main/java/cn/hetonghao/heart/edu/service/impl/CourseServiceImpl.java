package cn.hetonghao.heart.edu.service.impl;

import cn.hetonghao.heart.edu.bo.CourseBO;
import cn.hetonghao.heart.edu.entity.Course;
import cn.hetonghao.heart.edu.entity.CourseDescription;
import cn.hetonghao.heart.edu.mapper.CourseMapper;
import cn.hetonghao.heart.edu.service.ICourseDescriptionService;
import cn.hetonghao.heart.edu.service.ICourseService;
import cn.hetonghao.heart.edu.vo.CoursePageVO;
import cn.hetonghao.heart.edu.vo.api.CourseSaveVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-16
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Autowired
    private ICourseDescriptionService courseDescriptionService;

    @Override
    public List<CourseBO> page(IPage page, CoursePageVO vo) {
        return baseMapper.page(page, vo);
    }

    @Override
    public Integer countByVO(CoursePageVO vo) {
        return baseMapper.countByVO(vo);
    }

    @Override
    public CourseBO findDetail(String id) {
        return baseMapper.findDetail(id)
                .setCourseDescription(courseDescriptionService.findDetail(id));
    }

    @Override
    public boolean saveData(CourseSaveVO course) {
        boolean isInsert = course.getId() == null;
        if (isInsert) {
            course.setGmtCreate(LocalDateTime.now());
        }
        course.setGmtModified(LocalDateTime.now());
        super.saveOrUpdate(course);
        if (isInsert) {
            if (course.getCourseDescription() == null) {
                course.setCourseDescription(new CourseDescription());
            }
            return courseDescriptionService.save(course.getCourseDescription()
                    .setId(course.getId())
                    .setGmtCreate(LocalDateTime.now())
                    .setGmtModified(LocalDateTime.now()));
        } else {
            return courseDescriptionService.updateById(course.getCourseDescription()
                    .setId(course.getId())
                    .setGmtCreate(LocalDateTime.now())
                    .setGmtModified(LocalDateTime.now()));
        }
    }

    @Override
    public boolean delete(String id) {
        return super.removeById(id);
    }
}
