package cn.hetonghao.heart.edu.vo.api;

import cn.hetonghao.heart.edu.entity.Course;
import cn.hetonghao.heart.edu.entity.CourseDescription;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourseSaveVO extends Course {
    private CourseDescription courseDescription;
}