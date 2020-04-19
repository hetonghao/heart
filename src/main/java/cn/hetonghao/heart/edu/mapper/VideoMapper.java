package cn.hetonghao.heart.edu.mapper;

import cn.hetonghao.heart.edu.bo.VideoBO;
import cn.hetonghao.heart.edu.entity.Video;
import cn.hetonghao.heart.edu.vo.VideoPageVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 课程视频 Mapper 接口
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-19
 */
public interface VideoMapper extends BaseMapper<Video> {
    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List<VideoBO> page(IPage page, VideoPageVO vo);

    /**
     * 根据VO统计数量
     *
     * @param vo
     * @return
     */
    Integer countByVO(VideoPageVO vo);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    VideoBO findDetail(String id);
}
