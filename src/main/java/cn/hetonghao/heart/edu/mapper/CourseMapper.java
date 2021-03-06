package cn.hetonghao.heart.edu.mapper;

import cn.hetonghao.heart.edu.bo.CourseBO;
import cn.hetonghao.heart.edu.entity.Course;
import cn.hetonghao.heart.edu.vo.CoursePageVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-16
 */
public interface CourseMapper extends BaseMapper<Course> {
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
}
