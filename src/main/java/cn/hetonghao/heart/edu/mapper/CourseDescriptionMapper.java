package cn.hetonghao.heart.edu.mapper;

import cn.hetonghao.heart.edu.bo.CourseDescriptionBO;
import cn.hetonghao.heart.edu.entity.CourseDescription;
import cn.hetonghao.heart.edu.vo.CourseDescriptionPageVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 课程简介 Mapper 接口
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-16
 */
public interface CourseDescriptionMapper extends BaseMapper<CourseDescription> {
    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List<CourseDescriptionBO> page(IPage page, CourseDescriptionPageVO vo);

    /**
     * 根据VO统计数量
     *
     * @param vo
     * @return
     */
    Integer countByVO( CourseDescriptionPageVO vo);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    CourseDescriptionBO findDetail(String id);
}
