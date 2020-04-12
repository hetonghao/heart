package cn.hetonghao.heart.article.bo;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import cn.hetonghao.heart.article.entity.Article;

/**
 * <p>
 * 
 * </p>
 *
 * @author HeTongHao
 * @since 2020-03-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "ArticleBO对象", description = "")
public class ArticleBO extends Article {
}