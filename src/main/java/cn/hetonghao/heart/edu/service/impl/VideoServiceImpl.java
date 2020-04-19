package cn.hetonghao.heart.edu.service.impl;

import cn.hetonghao.heart.edu.bo.VideoBO;
import cn.hetonghao.heart.edu.entity.Video;
import cn.hetonghao.heart.edu.mapper.VideoMapper;
import cn.hetonghao.heart.edu.service.IVideoService;
import cn.hetonghao.heart.edu.vo.VideoPageVO;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 课程视频 服务实现类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-19
 */
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoService {

    @Override
    public List<VideoBO> page(IPage page, VideoPageVO vo) {
        return baseMapper.page(page, vo);
    }

    @Override
    public Integer countByVO(VideoPageVO vo) {
        return baseMapper.countByVO(vo);
    }

    @Override
    public VideoBO findDetail(String id) {
        return baseMapper.findDetail(id);
    }

    @Override
    public boolean saveData(Video video) {
        if (video.getId() == null) {
            video.setGmtCreate(LocalDateTime.now());
        }
        video.setGmtModified(LocalDateTime.now());
        return super.saveOrUpdate(video);
    }

    @Override
    public boolean delete(String id) {
        return super.removeById(id);
    }

    @Override
    public boolean deleteByCourseId(String courseId) {
        return remove(new UpdateWrapper<Video>().eq("course_id", courseId));
    }
}
