package cn.hetonghao.heart.edu.mapper;

import org.apache.ibatis.annotations.Param;
import cn.hetonghao.heart.edu.entity.Teacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.hetonghao.heart.edu.vo.TeacherPageVO;
import cn.hetonghao.heart.edu.bo.TeacherBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 讲师 Mapper 接口
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-09
 */
public interface TeacherMapper extends BaseMapper<Teacher> {
    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List<TeacherBO> page(@Param("page") IPage page, @Param("vo") TeacherPageVO vo);

    /**
     * 根据VO统计数量
     *
     * @param vo
     * @return
     */
    Integer countByVO(@Param("vo") TeacherPageVO vo);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    TeacherBO findDetail(String id);
}
