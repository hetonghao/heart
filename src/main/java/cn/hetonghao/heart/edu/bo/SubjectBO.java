package cn.hetonghao.heart.edu.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import cn.hetonghao.heart.edu.entity.Subject;

import java.util.List;

/**
 * <p>
 * 课程科目
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "SubjectBO对象", description = "课程科目")
public class SubjectBO extends Subject {
    private List<SubjectBO> children;
}