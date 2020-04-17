package cn.hetonghao.heart.edu.bo;

import cn.hetonghao.heart.edu.entity.Course;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "CourseBO对象", description = "课程")
public class CourseBO extends Course {
    private CourseDescriptionBO courseDescription;
}