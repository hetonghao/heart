package cn.hetonghao.heart.edu.service.impl;

import cn.hetonghao.heart.edu.bo.SubjectBO;
import cn.hetonghao.heart.edu.entity.Subject;
import cn.hetonghao.heart.edu.mapper.SubjectMapper;
import cn.hetonghao.heart.edu.service.ISubjectService;
import cn.hetonghao.heart.edu.vo.SubjectPageVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-13
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements ISubjectService {

    @Override
    public List<SubjectBO> page(IPage page, SubjectPageVO vo) {
        return baseMapper.page(page, vo);
    }

    @Override
    public Integer countByVO(SubjectPageVO vo) {
        return baseMapper.countByVO(vo);
    }

    @Override
    public SubjectBO findDetail(String id) {
        return baseMapper.findDetail(id);
    }

    @Override
    public boolean saveData(Subject subject) {
        if (subject.getId() == null) {
            subject.setGmtCreate(LocalDateTime.now());
        }
        subject.setGmtModified(LocalDateTime.now());
        return super.saveOrUpdate(subject);
    }

    @Override
    public List<SubjectBO> tree() {
        List<SubjectBO> rootSubjectList = baseMapper.page(null, new SubjectPageVO().setParentId("0"));
        rootSubjectList.forEach(rootSubject ->
                rootSubject.setChildren(baseMapper.page(null
                        , new SubjectPageVO().setParentId(rootSubject.getId())))
        );
        return rootSubjectList;
    }

    @Override
    public boolean delete(String id) {
        return super.removeById(id);
    }
}
