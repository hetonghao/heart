package cn.hetonghao.heart.edu.mapper;

import org.apache.ibatis.annotations.Param;
import cn.hetonghao.heart.edu.entity.Subject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.hetonghao.heart.edu.vo.SubjectPageVO;
import cn.hetonghao.heart.edu.bo.SubjectBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 课程科目 Mapper 接口
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-13
 */
public interface SubjectMapper extends BaseMapper<Subject> {
    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List<SubjectBO> page(@Param("page") IPage page, @Param("vo") SubjectPageVO vo);

    /**
     * 根据VO统计数量
     *
     * @param vo
     * @return
     */
    Integer countByVO(@Param("vo") SubjectPageVO vo);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    SubjectBO findDetail(String id);
}
