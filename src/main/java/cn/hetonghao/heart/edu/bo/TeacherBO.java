package cn.hetonghao.heart.edu.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import cn.hetonghao.heart.edu.entity.Teacher;

/**
 * <p>
 * 讲师
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "TeacherBO对象", description = "讲师")
public class TeacherBO extends Teacher {
}