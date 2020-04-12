package cn.hetonghao.heart.article.service.impl;

import cn.hetonghao.heart.article.entity.Article;
import cn.hetonghao.heart.article.vo.ArticlePageVO;
import cn.hetonghao.heart.article.mapper.ArticleMapper;
import cn.hetonghao.heart.article.service.IArticleService;
import cn.hetonghao.heart.article.bo.ArticleBO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author HeTongHao
 * @since 2020-03-28
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Override
    public List<ArticleBO> page(IPage page, ArticlePageVO vo) {
        return baseMapper.page(page, vo);
    }
	
    @Override
    public ArticleBO findDetail(Long id) {
        return baseMapper.findDetail(id);
    }
	
    @Override
    public boolean saveData(Article article) {
        return super.saveOrUpdate(article);
    }

    @Override
    public boolean delete(Long id) {
        return super.removeById(id);
    }
}
