package cn.hetonghao.heart.edu.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import cn.hetonghao.heart.edu.entity.Chapter;

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
@ApiModel(value = "ChapterBO对象", description = "课程")
public class ChapterBO extends Chapter {
}