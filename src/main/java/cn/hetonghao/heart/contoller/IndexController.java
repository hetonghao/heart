package cn.hetonghao.heart.contoller;

import cn.hetonghao.heart.mapper.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author HeTongHao
 * @since 2020/3/17 23:45
 */
@Controller
public class IndexController {
    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping("index")
    public String hello(Model model) {
        model.addAttribute("msg", "hello,Thymeleaf!My name is HTH!");
        model.addAttribute("htmlTag", "<h2>html标签转义</h2");
        model.addAttribute("articles", articleMapper.list());
        return "index";
    }
}
