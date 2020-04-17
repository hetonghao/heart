package cn.hetonghao.heart.edu.service.impl;

import cn.hetonghao.heart.edu.entity.Chapter;
import cn.hetonghao.heart.edu.vo.ChapterPageVO;
import cn.hetonghao.heart.edu.mapper.ChapterMapper;
import cn.hetonghao.heart.edu.service.IChapterService;
import cn.hetonghao.heart.edu.bo.ChapterBO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
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

    @Override
    public List<ChapterBO> page(IPage page, ChapterPageVO vo) {
        return baseMapper.page(page, vo);
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
        return super.saveOrUpdate(chapter);
    }

    @Override
    public boolean delete(String id) {
        return super.removeById(id);
    }
}
