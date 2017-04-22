package com.weishu.admin.user;

import com.github.pagehelper.PageInfo;
import com.weishu.common.enums.ResultCodeEnum;
import com.weishu.common.vo.UnifiedResponse;
import com.weishu.constant.DeleteEnum;
import com.weishu.web.user.entity.User;
import com.weishu.web.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

/**
 * 后台系统
 * Created by lianle on 2015/5/27.
 */
@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET}, value = "admin/user/")
@Controller
public class AdminUserController {


    @Autowired
    UserService userService;
    /**
     * 跳转到人员list页面
     *
     * @return
     */
    @RequestMapping("list")
    public String toUserList() {

        return "admin/user/userList";
    }

    /**
     * 跳转到人员添加页面
     *
     * @return
     */
    @RequestMapping("toadd")
    public String toAddUser() {

        return "admin/user/addUser";
    }

    /**
     * 跳转到人员修改页面
     *
     * @return
     */
    @RequestMapping("toupdate")
    public String toUpdateUser(Long id, Model model) {
        final User user = userService.queryById(id);
        model.addAttribute("user", user);
        return "admin/user/toUpdateUser";
    }

    /**
     * 人员查询列表接口
     * @return
     */
    @ResponseBody
    @RequestMapping("getlist")
    public HashMap<String, Object> getList(@RequestParam(required = false, value = "page", defaultValue = "1") int pageNo,
                                   @RequestParam(required = false, value = "rows", defaultValue = "10") int pageSize) {
        PageInfo<User> usersInfo = userService.queryList(pageNo, pageSize);

        long total = usersInfo.getTotal();

        final HashMap<String, Object> returnMap = new HashMap<>();
        returnMap.put("total", total);
        if (usersInfo.getSize() > 0) {
            returnMap.put("rows", usersInfo.getList());
        }
        return returnMap;

    }

    /**
     * 新增接口
     * @return
     */
    @ResponseBody
    @RequestMapping("add")
    public UnifiedResponse save(User user) {

        Date now = new Date();
        user.setCreateTime(now);
        user.setUpdateTime(now);
        user.setIsDelete(DeleteEnum.NOT_DELETE.getCode());
        //插入数据
        userService.save(user);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "保存成功");
        return unifiedResponse;
    }

    /**
     * 人员更新接口
     * @return
     */
    @ResponseBody
    @RequestMapping("update")
    public UnifiedResponse update(User user) {

        user.setUpdateTime(new Date());

        //更新数据
        userService.update(user);
        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "更新成功");
        return unifiedResponse;
    }

    /**
     * 人员删除接口
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("del")
    public UnifiedResponse del(@RequestParam(value = "id") long id) {

        User user = userService.queryById(id);
        if (user == null) {
            return new UnifiedResponse(ResultCodeEnum.PARAMETER_ERROR.getCode(), "没有这个人员");
        }
        //状态删除数据
        userService.del(user);

        UnifiedResponse unifiedResponse = new UnifiedResponse(ResultCodeEnum.SUCCESS.getCode(), "删除成功");

        return unifiedResponse;

    }

}
