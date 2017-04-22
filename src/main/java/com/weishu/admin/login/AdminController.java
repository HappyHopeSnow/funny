package com.weishu.admin.login;

import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Jackie on 2015/9/14.
 * Email : chenxinhua@ishehui.com
 */
@RequestMapping(value = "admin", method = {RequestMethod.POST, RequestMethod.GET})
@Controller
public class AdminController {

    static final Logger LOGGER = Logger.getLogger(AdminController.class);



    /**
     * 跳转到后台管理登陆页面
     *
     * @return
     */
    @RequestMapping("")
    public String toManageLogin() {

        return "admin/login";
    }


    /**
     *
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("login")
    @ResponseBody
    public UnifiedResponse login(String name, String password, HttpServletResponse response) {
        LOGGER.info("name=" + name);
        LOGGER.info("password=" + password);
        if (!"lianle".equals(name) || !"123456".equals(password)) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "用户名或密码错误");
        }
//        Subject currentUser = SecurityUtils.getSubject();
//        if (!currentUser.isAuthenticated()) {
//            UsernamePasswordToken token = new UsernamePasswordToken(name, password);
//            token.setRememberMe(true);
//
//            try{
//                currentUser.main(token);
////                String serverDigest = HmacSHA256Utils.digest(StatelessRealm.getKey(), name);
////                CookieUtil.addCookies(response, "name", name, 60 * 60 * 24);
////                CookieUtil.addCookies(response, "digest", serverDigest, 60*60*24);
//                //返回json数据
//                return new UnifiedResponse();
//            }catch(Exception ex){
////            }catch(UnknownAccountException ex){
//                LOGGER.debug("账号错误");
////            }catch(IncorrectCredentialsException ex){
//                LOGGER.debug("密码错误");
////            }catch(LockedAccountException ex){
//                LOGGER.debug("账号已被锁定，请与系统管理员联系");
////            }catch(AuthenticationException ex){
//                LOGGER.debug("您没有授权!");
//            }
//            return new UnifiedResponse(401, "登陆失败");
//        }
        return new UnifiedResponse();

    }

    @RequestMapping("logout")
    public String logout(HttpServletResponse response, HttpServletRequest request) {
//        CookieUtil.delCookies(request, response, "digest");
//        CookieUtil.delCookies(request, response, "name");
        return "redirect:/admin";
    }

    /**
     * 跳转到任务列表
     *
     * @return
     */
    @RequestMapping("main")
    public String toListTask(/*@CurrentUser SysUser loginUser, Model model*/) {
//        Set<String> permissions = userService.findPermissions(loginUser.getUsername());
//        SysResourceChild menus = resourceService.findMenus(permissions);
//        model.addAttribute("sysResources", menus);
//        model.addAttribute("user", loginUser);
        return "admin/main";
    }

//    @RequestMapping("listmenu")
//    @ResponseBody
//    public SysResourceChild listMenu(@CurrentUser SysUser loginUser) {
//        Set<String> permissions = userService.findPermissions(loginUser.getUsername());
//        SysResourceChild menus = resourceService.findMenus(permissions);
//        return menus;
//    }

}
