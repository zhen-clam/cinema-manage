package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dao.ConsumptionDao;
import com.example.demo.dao.RechargeDao;
import com.example.demo.model.Consumption;
import com.example.demo.model.Recharge;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Z
 */
@Service
public class RecordService {
    @Resource
    private ConsumptionDao consumptionDao;
    @Resource
    private RechargeDao rechargeDao;


    /**
     * 条件查消费
     * @param consumption
     * @return
     */
    public Object getConByUser(Consumption consumption) {
        Map<Object, Object> map = new HashMap<>();
        List<Consumption> list = consumptionDao.selectConsumption(consumption);
        PageInfo<Consumption> pageInfo = new PageInfo<>(list);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 条件查充值
     * @param recharge
     * @return
     */
    public Object getRecByUser(Recharge recharge) {
        Map<Object, Object> map = new HashMap<>();
        List<Recharge> list = rechargeDao.selectList(recharge);
        PageInfo<Recharge> pageInfo = new PageInfo<>(list);
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 删除充值记录
     * @param ids
     */
    public void deleteRecharge(Long[] ids){
        rechargeDao.deleteRecharge(ids);
    }

    /**
     * 删除消费记录
     * @param ids
     */
    public void deleteConsumption(Long[] ids){
        consumptionDao.deleteConsumption(ids);
    }


}
