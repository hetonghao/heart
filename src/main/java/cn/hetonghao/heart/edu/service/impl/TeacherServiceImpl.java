package cn.hetonghao.heart.edu.service.impl;

import cn.hetonghao.heart.edu.bo.TeacherBO;
import cn.hetonghao.heart.edu.entity.Teacher;
import cn.hetonghao.heart.edu.mapper.TeacherMapper;
import cn.hetonghao.heart.edu.service.ITeacherService;
import cn.hetonghao.heart.edu.vo.TeacherPageVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-09
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Override
    public List<TeacherBO> page(IPage page, TeacherPageVO vo) {
        return baseMapper.page(page, vo);
    }

    @Override
    public Integer countByVO(TeacherPageVO vo) {
        return baseMapper.countByVO(vo);
    }

    @Override
    public TeacherBO findDetail(String id) {
        return baseMapper.findDetail(id);
    }

    @Override
    public boolean saveData(Teacher teacher) {
        if (teacher.getId() == null) {
            teacher.setGmtCreate(LocalDateTime.now());
        }
        teacher.setGmtModified(LocalDateTime.now());
        return super.saveOrUpdate(teacher);
    }

    @Override
    public boolean delete(String id) {
        return super.removeById(id);
    }
}
