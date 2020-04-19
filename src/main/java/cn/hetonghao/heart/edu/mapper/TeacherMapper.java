package cn.hetonghao.heart.edu.mapper;

import cn.hetonghao.heart.edu.bo.TeacherBO;
import cn.hetonghao.heart.edu.entity.Teacher;
import cn.hetonghao.heart.edu.vo.TeacherPageVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    List<TeacherBO> page(IPage page, TeacherPageVO vo);

    /**
     * 根据VO统计数量
     *
     * @param vo
     * @return
     */
    Integer countByVO(TeacherPageVO vo);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    TeacherBO findDetail(String id);
}
