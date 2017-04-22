package com.weishu.web.user.controller;

import com.weishu.web.user.entity.User;
import com.weishu.web.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Description: <br>
 *
 * @author <a href=mailto:lianle@meituan.com>连乐</a>
 * @date 2017/3/30 下午9:57
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        Long userId = Long.parseLong(request.getParameter("id"));
        User user = this.userService.queryById(userId);
        model.addAttribute("user", user);
        return "index";
    }
}