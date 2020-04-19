package cn.hetonghao.heart.edu.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import cn.hetonghao.heart.edu.entity.Video;

/**
 * <p>
 * 课程视频
 * </p>
 *
 * @author HeTongHao
 * @since 2020-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "VideoBO对象", description = "课程视频")
public class VideoBO extends Video {
}