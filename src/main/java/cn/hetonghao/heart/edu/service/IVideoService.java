package cn.hetonghao.heart.edu.service;

import cn.hetonghao.heart.edu.entity.Video;
import cn.hetonghao.heart.edu.vo.VideoPageVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.hetonghao.heart.edu.bo.VideoBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 课程视频 服务类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-19
 */
public interface IVideoService extends IService<Video> {

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
     * @param video
     * @return
     */
    boolean saveData(Video video);

    /**
     * 根据课程id删除
     *
     * @param courseId
     * @return
     */
    boolean deleteByCourseId(String courseId);
}
