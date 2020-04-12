package cn.hetonghao.heart.article.vo;

import cn.hetonghao.mybatisplus.vo.PageVO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *  分页对象
 * </p>
 *
 * @author HeTongHao
 * @since 2020-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ArticlePageVO对象", description = "")
public class ArticlePageVO extends PageVO {
}