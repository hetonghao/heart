package cn.hetonghao.heart.edu.service.impl;

import cn.hetonghao.heart.edu.bo.ChapterBO;
import cn.hetonghao.heart.edu.entity.Chapter;
import cn.hetonghao.heart.edu.mapper.ChapterMapper;
import cn.hetonghao.heart.edu.service.IChapterService;
import cn.hetonghao.heart.edu.service.IVideoService;
import cn.hetonghao.heart.edu.vo.ChapterPageVO;
import cn.hetonghao.heart.edu.vo.VideoPageVO;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-16
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements IChapterService {
    @Autowired
    private IVideoService videoService;

    @Override
    public List<ChapterBO> page(IPage page, ChapterPageVO vo) {
        List<ChapterBO> chapterList = baseMapper.page(page, vo);
        VideoPageVO videoPageVo = new VideoPageVO();
        chapterList.forEach(chapter ->
                chapter.setVideoList(videoService.page(null, videoPageVo.setChapterId(chapter.getId()))));
        return chapterList;
    }

    @Override
    public Integer countByVO(ChapterPageVO vo) {
        return baseMapper.countByVO(vo);
    }

    @Override
    public ChapterBO findDetail(String id) {
        return baseMapper.findDetail(id);
    }

    @Override
    public boolean saveData(Chapter chapter) {
        if (chapter.getId() == null) {
            chapter.setGmtCreate(LocalDateTime.now());
        }
        chapter.setGmtModified(LocalDateTime.now());
        return super.saveOrUpdate(chapter);
    }

    @Override
    public boolean delete(String id) {
        return super.removeById(id);
    }

    @Override
    public boolean deleteByCourseId(String courseId) {
        return remove(new UpdateWrapper<Chapter>().eq("course_id", courseId));
    }
}
