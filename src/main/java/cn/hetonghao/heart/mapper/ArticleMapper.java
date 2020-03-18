package cn.hetonghao.heart.mapper;

import cn.hetonghao.heart.entity.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author HeTongHao
 * @since 2020-03-02
 */
@Repository
public interface ArticleMapper {
    List<Article> list();
}
