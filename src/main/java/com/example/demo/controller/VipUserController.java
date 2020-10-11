package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.model.VipUser;
import com.example.demo.service.VipUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Z
 */
@Controller
@RequestMapping("/vipUser/")
public class VipUserController {

    @Resource
    private VipUserService vipUserService;

    @RequestMapping("vipcard")
    public String vipcard() {
        return "vipcard";
    }

    @RequestMapping("cardReplace")
    public String cardReplace() {
        return "cardReplace";
    }

    @RequestMapping("userBuy")
    public String userBuy(){
        return "userBuy";
    }
    @RequestMapping("UserRecharge")
    public String UserRecharge() {
        return "UserRecharge";
    }

    @RequestMapping("userconsume")
    public String userconsume() {
        return "userconsume";
    }

    @RequestMapping("vipCardLose")
    public String cardLose() {
        return "vipcardlose";
    }

    @RequestMapping("integralConvertible")
    public  String integralConvertible(){
        return "integralConvertible";
    }

    @ResponseBody
    @RequestMapping("selectAll")
    public Object selectAll(VipUser vipUser, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<VipUser> lists = vipUserService.selectAll(vipUser);
        return getObject(lists);
    }

    @ResponseBody
    @RequestMapping("selectByStatus")
    public Object selectByStatus(VipUser vipUser, Integer page, Integer rows) {
        PageHelper.startPage(page, rows);
        List<VipUser> lists = vipUserService.selectByStatus(vipUser);
        return getObject(lists);
    }

    private Object getObject(List<VipUser> lists) {
        PageInfo<VipUser> pageInfo = new PageInfo<>(lists);
        Map<String, Object> map = new HashMap<>();
        map.put("total", pageInfo.getTotal());
        map.put("rows", pageInfo.getList());
        return map;
    }

    @ResponseBody
    @RequestMapping("insert")
    public Object insert(VipUser vipUser) {
        vipUserService.insert(vipUser);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "插入成功");
        return map;

    }

    @ResponseBody
    @RequestMapping("deletes")
    public Object deletes(Long[] ids) {
        vipUserService.deletes(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "批删除成功");
        return map;
    }

    @ResponseBody
    @RequestMapping("recharge")
    public Object recharge(VipUser vipUser) {
        vipUserService.recharge(vipUser);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "充值成功");
        return map;

    }

    @ResponseBody
    @RequestMapping("consume")
    public Object consume(VipUser vipUser) {
        vipUserService.consume(vipUser);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "消费成功,积分更新完成");
        return map;

    }

    @ResponseBody
    @RequestMapping("cardLose")
    public Object cardLose(VipUser vipUser) {
        vipUserService.cardLose(vipUser);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "挂失/解除挂失成功");
        return map;

    }
    @ResponseBody
    @RequestMapping("vipUserBuy")
    public Object userBuy(VipUser vipUser){
        vipUserService.userBuy(vipUser);
        Map<Object, Object> map = new HashMap<>();
        map.put("code",1);
        map.put("msg","消费成功");
        return map;
    }

    @ResponseBody
    @RequestMapping("integralCon")
    public  Object integralCon(VipUser vipUser){
        Map<String, Object> map = new HashMap<>();
        VipUser card = new VipUser();
        card.setIntegral(vipUser.getIntegral());
        card.setId(vipUser.getId());
        vipUserService.integralConvertible(card);
        map.put("code",1);
        map.put("msg","兑换成功");
        return map;
    }

    /**
     * 先挂失后通过用户信息查找卡号后进行补卡
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("replaceCard")
    public  Object replaceCard(User user){
        Map<String, Object> map = new HashMap<>();
        VipUser vip = new VipUser();
        vip.setId(user.getCid());
        vipUserService.replaceCard(vip);
        map.put("code",1);
        map.put("msg","补卡成功");
        return map;

    }

}
