package cn.hetonghao.heart.edu.service;

import cn.hetonghao.heart.edu.entity.Teacher;
import cn.hetonghao.heart.edu.vo.TeacherPageVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.hetonghao.heart.edu.bo.TeacherBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-09
 */
public interface ITeacherService extends IService<Teacher> {

    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List<TeacherBO> page(IPage page, TeacherPageVO vo);

    /**
     * 根据VO统计数量
     *
     * @param vo
     * @return
     */
    Integer countByVO(TeacherPageVO vo);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    TeacherBO findDetail(String id);

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
     * @param teacher
     * @return
     */
    boolean saveData(Teacher teacher);
}
