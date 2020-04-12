package cn.hetonghao.heart.article.mapper;

import org.apache.ibatis.annotations.Param;
import cn.hetonghao.heart.article.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import cn.hetonghao.heart.article.vo.ArticlePageVO;
import cn.hetonghao.heart.article.bo.ArticleBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author HeTongHao
 * @since 2020-03-28
 */
public interface ArticleMapper extends BaseMapper<Article> {
    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List<ArticleBO> page(@Param("page") IPage page, @Param("vo") ArticlePageVO vo);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    ArticleBO findDetail(Long id);
}
