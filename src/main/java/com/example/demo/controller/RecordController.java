package com.example.demo.controller;

import com.example.demo.model.Consumption;
import com.example.demo.model.Recharge;
import com.example.demo.service.RecordService;
import com.github.pagehelper.PageHelper;
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
@RequestMapping("/vip/")
public class RecordController {
    @Resource
    private RecordService recordService;
    @RequestMapping("UserRecharge")
    public String UserRecharge(){
        return "recharge";
    }
    @RequestMapping("userBuy")
    public String userBuy(){
        return "consumption";
    }

    /**
     * 通过姓名查消费
     * @param consumption
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("conByUser")
    public Object conByUser(Consumption consumption,Integer page,Integer rows){
        PageHelper.startPage(page, rows);
        Object user = recordService.getConByUser(consumption);
        return user;
    }

    /**
     * 通过姓名查充值
     * @param recharge
     * @param page
     * @param rows
     * @return
     */
    @ResponseBody
    @RequestMapping("recByUser")
    public Object recByUser(Recharge recharge,Integer page,Integer rows){
        PageHelper.startPage(page, rows);
        Object user = recordService.getRecByUser(recharge);
        return user;
    }

    @ResponseBody
    @RequestMapping("deleteRecharge")
    public Object deletes(Long[] ids) {
        recordService.deleteRecharge(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "删除充值记录成功");
        return map;
    }

    @ResponseBody
    @RequestMapping("deleteConsumption")
    public Object deleteConsumption(Long[] ids) {
        recordService.deleteConsumption(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "删除消费记录成功");
        return map;
    }
}
