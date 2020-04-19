package cn.hetonghao.heart.edu.service.impl;

import cn.hetonghao.heart.edu.bo.CourseBO;
import cn.hetonghao.heart.edu.entity.Course;
import cn.hetonghao.heart.edu.entity.CourseDescription;
import cn.hetonghao.heart.edu.mapper.CourseMapper;
import cn.hetonghao.heart.edu.service.IChapterService;
import cn.hetonghao.heart.edu.service.ICourseDescriptionService;
import cn.hetonghao.heart.edu.service.ICourseService;
import cn.hetonghao.heart.edu.service.IVideoService;
import cn.hetonghao.heart.edu.vo.CoursePageVO;
import cn.hetonghao.heart.edu.vo.api.CourseSaveVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional(rollbackFor = Exception.class)
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
    @Autowired
    private ICourseDescriptionService courseDescriptionService;
    @Autowired
    private IChapterService chapterService;
    @Autowired
    private IVideoService videoService;

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
        CourseBO course = baseMapper.findDetail(id);
        if (course == null) {
            return null;
        }
        return course.setCourseDescription(courseDescriptionService.findDetail(id));
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
        return videoService.deleteByCourseId(id)
                && chapterService.deleteByCourseId(id)
                && courseDescriptionService.delete(id)
                && super.removeById(id);
    }
}
