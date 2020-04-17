package cn.hetonghao.heart.edu.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import cn.hetonghao.heart.edu.entity.CourseDescription;

/**
 * <p>
 * 课程简介
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "CourseDescriptionBO对象", description = "课程简介")
public class CourseDescriptionBO extends CourseDescription {
}