package cn.hetonghao.heart.edu.service.impl;

import cn.hetonghao.heart.edu.bo.CourseDescriptionBO;
import cn.hetonghao.heart.edu.entity.CourseDescription;
import cn.hetonghao.heart.edu.mapper.CourseDescriptionMapper;
import cn.hetonghao.heart.edu.service.ICourseDescriptionService;
import cn.hetonghao.heart.edu.vo.CourseDescriptionPageVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 课程简介 服务实现类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-16
 */
@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription> implements ICourseDescriptionService {

    @Override
    public List<CourseDescriptionBO> page(IPage page, CourseDescriptionPageVO vo) {
        return baseMapper.page(page, vo);
    }

    @Override
    public Integer countByVO(CourseDescriptionPageVO vo) {
        return baseMapper.countByVO(vo);
    }
	
    @Override
    public CourseDescriptionBO findDetail(String id) {
        return baseMapper.findDetail(id);
    }
	
    @Override
    public boolean saveData(CourseDescription courseDescription) {
        return super.saveOrUpdate(courseDescription);
    }

    @Override
    public boolean delete(String id) {
        return super.removeById(id);
    }
}
