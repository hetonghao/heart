package cn.hetonghao.heart.edu.service;

import cn.hetonghao.heart.edu.entity.Subject;
import cn.hetonghao.heart.edu.vo.SubjectPageVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.hetonghao.heart.edu.bo.SubjectBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-13
 */
public interface ISubjectService extends IService<Subject> {

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
     * @param subject
     * @return
     */
    boolean saveData(Subject subject);

    /**
     * 树形菜单
     *
     * @return
     */
    List<SubjectBO> tree();
}
