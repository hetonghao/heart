package cn.hetonghao.heart.article.controller;

import cn.hetonghao.heart.article.bo.ArticleBO;
import cn.hetonghao.heart.article.entity.Article;
import cn.hetonghao.heart.article.service.IArticleService;
import cn.hetonghao.heart.article.vo.ArticlePageVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 关注记录 前端控制器
 * </p>
 *
 * @author HeTongHao
 * @since 2020-03-28
 */
@Api(tags = {"关注记录"})
@Controller
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    private IArticleService articleService;

    @GetMapping
    @ApiOperation(value = "列表", notes = "所有数据列表查询,传入pageNumber与pageSize可分页")
    public String page(@RequestParam(required = false) ArticlePageVO vo, Model model) {
        if (vo == null) {
            vo = new ArticlePageVO();
        }
        IPage page = vo.generatePage();
        articleService.page(page, vo);
        model.addAttribute("page", page);
        return "article/list";
    }

    @GetMapping("list")
    @ResponseBody
    @ApiOperation(value = "列表", notes = "所有数据列表查询,传入pageNumber与pageSize可分页")
    public List<ArticleBO> list(@RequestParam("id") Long id) {
        ArticlePageVO vo = new ArticlePageVO();
        IPage page = vo.generatePage();
        return articleService.page(page, vo);
    }

    @GetMapping("{id}")
    @ApiOperation(value = "根据id查询")
    public String detail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("bo", articleService.findDetail(id));
        return "article/edit";
    }

    @PostMapping("save")
    @ApiOperation(value = "新增或更新", notes = "新增或更新，id is null新增数据，id not null更新数据")
    public String saveOrUpdate(Article article) {
        articleService.saveData(article);
        return "redirect:/articles";
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "删除")
    public String delete(@PathVariable("id") Long id) {
        articleService.delete(id);
        return "redirect:/articles";
    }
}
