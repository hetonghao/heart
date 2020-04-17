package cn.hetonghao.heart.edu.service;

import cn.hetonghao.heart.edu.entity.Course;
import cn.hetonghao.heart.edu.vo.CoursePageVO;
import cn.hetonghao.heart.edu.vo.api.CourseSaveVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.hetonghao.heart.edu.bo.CourseBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-16
 */
public interface ICourseService extends IService<Course> {

    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List<CourseBO> page(IPage page, CoursePageVO vo);

    /**
     * 根据VO统计数量
     *
     * @param vo
     * @return
     */
    Integer countByVO(CoursePageVO vo);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    CourseBO findDetail(String id);

     /**
     * 根据id删除,逻辑处理
     *
     * @param id
     * @return
     */
    boolean delete(String id);

    /**
     * 保存,逻辑处理
     *
     * @param course
     * @return
     */
    boolean saveData(CourseSaveVO course);
}
