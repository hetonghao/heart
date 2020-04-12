package cn.hetonghao.heart.user.controller;

import cn.hetonghao.heart.user.bo.Admin;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author HeTongHao
 * @since 2020/4/9 22:37
 */
@Api(tags = {"管理员"})
@RestController
@RequestMapping("admin")
public class AdminController {
    @PostMapping("login")
    @ApiOperation(value = "登录")
    private Map<String, String> login(@RequestBody Admin admin) {
        Map<String, String> token = Maps.newHashMap();
        token.put("token", "admin");
        return token;
    }

    @GetMapping("info")
    @ApiOperation(value = "info")
    private Map<String, String> info(@RequestParam String token) {
        Map<String, String> admin = Maps.newHashMap();
        admin.put("name", "HTH");
        admin.put("introduction", "I am a super administrator");
        admin.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return admin;
    }

    @PostMapping("logout")
    @ApiOperation(value = "logout")
    private void logout() {
    }
}
