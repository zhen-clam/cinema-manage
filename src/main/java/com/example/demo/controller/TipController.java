package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserBirth;
import com.example.demo.service.TipService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Z
 */
@Controller
@RequestMapping("/birth/")
public class TipController {
    @Resource
    private TipService tipService;
    @RequestMapping("findBirthday")
    public String findBirthday(){
        return "findBirthday";
    }

    @RequestMapping("BirthTip")
    public  String BirthTip(){
        return "BirthTip";
    }

    @ResponseBody
    @RequestMapping("selectAll")
    public Object selectAll(UserBirth user, Integer page, Integer rows){
        Object all = null;
        if(null!=user.getSearchFuture()){
            //查未来生日用户
            all = tipService.search(user, page, rows);
        }else{
            //通过姓名查或者查全部
            all=tipService.selectAll(user,page,rows);
        }
        return all;
    }

    /**
     * 会员生日提醒
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("tip")

    public Object tip(User user){
        Map<Object, Object> map = new HashMap<>();
        Integer tip = tipService.tip(user);
        if(tip==1){
            map.put("code", 1);
            map.put("msg", "提醒成功");
        }else if(tip==2){
            map.put("code", 2);
            map.put("msg", "取消提醒成功");
        }else{
            map.put("code", 0);
            map.put("msg", "失败");
        }
        return map;
    }
}
