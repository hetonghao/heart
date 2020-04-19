package cn.hetonghao.heart.edu.mapper;

import cn.hetonghao.heart.edu.bo.SubjectBO;
import cn.hetonghao.heart.edu.entity.Subject;
import cn.hetonghao.heart.edu.vo.SubjectPageVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
    List<SubjectBO> page(IPage page, SubjectPageVO vo);

    /**
     * 根据VO统计数量
     *
     * @param vo
     * @return
     */
    Integer countByVO(SubjectPageVO vo);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    SubjectBO findDetail(String id);
}
