package cn.hetonghao.heart;

import cn.hetonghao.heart.entity.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author HeTongHao
 * @since 2020/3/17 23:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Main1 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void main1() {
        List<Article> articles = jdbcTemplate.query("select * from article", new BeanPropertyRowMapper<>(Article.class));
        articles.forEach(article -> {
            System.out.println(article.getName());
        });
    }
}
