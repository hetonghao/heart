package cn.hetonghao.heart.contoller;

import cn.hetonghao.heart.entity.Article;
import cn.hetonghao.heart.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HeTongHao
 * @since 2020/3/17 23:45
 */
@RestController
@RequestMapping("index")
public class IndexController {
    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping("hello")
    public String hello() {
        List<Article> articles = articleMapper.list();
        return "hello hth";
    }
}
