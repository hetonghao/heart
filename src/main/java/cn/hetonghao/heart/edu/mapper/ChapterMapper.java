package cn.hetonghao.heart.edu.mapper;

import cn.hetonghao.heart.edu.bo.ChapterBO;
import cn.hetonghao.heart.edu.entity.Chapter;
import cn.hetonghao.heart.edu.vo.ChapterPageVO;
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
public interface ChapterMapper extends BaseMapper<Chapter> {
    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List<ChapterBO> page(IPage page, ChapterPageVO vo);

    /**
     * 根据VO统计数量
     *
     * @param vo
     * @return
     */
    Integer countByVO(ChapterPageVO vo);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    ChapterBO findDetail(String id);
}
