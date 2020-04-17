package cn.hetonghao.heart.edu.service;

import cn.hetonghao.heart.edu.entity.CourseDescription;
import cn.hetonghao.heart.edu.vo.CourseDescriptionPageVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.hetonghao.heart.edu.bo.CourseDescriptionBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 * 课程简介 服务类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-16
 */
public interface ICourseDescriptionService extends IService<CourseDescription> {

    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List<CourseDescriptionBO> page(IPage page, CourseDescriptionPageVO vo);

    /**
     * 根据VO统计数量
     *
     * @param vo
     * @return
     */
    Integer countByVO(CourseDescriptionPageVO vo);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    CourseDescriptionBO findDetail(String id);

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
     * @param courseDescription
     * @return
     */
    boolean saveData(CourseDescription courseDescription);
}
