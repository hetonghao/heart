package cn.hetonghao.heart.article.service;

import cn.hetonghao.heart.article.entity.Article;
import cn.hetonghao.heart.article.vo.ArticlePageVO;
import com.baomidou.mybatisplus.extension.service.IService;
import cn.hetonghao.heart.article.bo.ArticleBO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-03-28
 */
public interface IArticleService extends IService<Article> {

    /**
     * 根据VO分页查询
     *
     * @param page
     * @param vo
     * @return
     */
    List<ArticleBO> page(IPage page, ArticlePageVO vo);

    /**
     * 根据id查询详情
     *
     * @param id
     * @return
     */
    ArticleBO findDetail(Long id);
    
    
     /**
     * 根据id删除,逻辑处理
     *
     * @param id
     * @return
     */
    boolean delete(Long id);
    /**
     * 保存,逻辑处理
     *
     * @param article
     * @return
     */
    boolean saveData(Article article);
}
