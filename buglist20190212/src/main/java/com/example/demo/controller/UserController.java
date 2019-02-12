package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    UserEntity user = new UserEntity();

    @RequestMapping(value={"/login","/"})
    public String login(Model model) {

        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth instanceof AnonymousAuthenticationToken) {
                return "login";
            } else {
                //获取用户登录权限详细
                Object  pinciba=auth.getPrincipal();
                if(pinciba instanceof UserDetails){
                    UserDetails userDetail = ((UserDetails) pinciba);
                    model.addAttribute("username", userDetail.getUsername());
                    UserEntity u =userServiceImpl.getByUsername(userDetail.getUsername());
                    model.addAttribute("realName",u.getUsername());
                }

                //登录成功跳到主页
                System.out.println("修改Bug信息成功！");
                model.addAttribute("message","修改Bug信息成功");
                return "auto";

            }
        } catch (Exception e) {
            e.printStackTrace();
            return "login";
        }


    }






/*    *//**
     * 获取角色列表
     * @return
     *//*
    @RequestMapping(value = "/admin-list")
    @ResponseBody
    public ModelAndView getUserList() {
        List<User> userList = new ArrayList<User>();
        try {
            System.err.println("查询角色列表");
            userList =userServiceImpl.loadUserByUsername();
        } catch (Exception e) {

        }
        return new ModelAndView("admin-list", "userList", userList);
    }*/


    /**
     * 跳转到添加角色页面
     * @return
     */
    @RequestMapping(value = "/admin-add")
    public ModelAndView  addSystemUser(Model model){
        model.addAttribute(user);
        return new ModelAndView("admin-add");
    }


    /**
     * 添加一个用户
     * @param user
     * @return
     */
    /*@RequestMapping(value = "/addSingleUser",method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addSingleUser(@ModelAttribute(value="user")User user){
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            userServiceImpl.save(user);
            //TODO 可以封装成工具类
            result.put("flag", true);
            result.put("msg", "保存成功");
        }catch (Exception e){
            result.put("flag", false);
            result.put("msg", "系统错误，请联系管理员！");
        }
        return result;
    }*/

    /**
     * 无权限访问页
     * @return
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accesssDenied() {
        ModelAndView model = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.setViewName("403");
        return model;
    }

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "user/user";
    }


}
