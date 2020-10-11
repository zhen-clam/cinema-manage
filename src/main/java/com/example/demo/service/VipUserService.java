package com.example.demo.service;

import cn.hutool.core.date.DateUtil;
import com.example.demo.dao.VipUserDao;
import com.example.demo.dao.ConsumptionDao;
import com.example.demo.dao.RechargeDao;
import com.example.demo.model.Consumption;
import com.example.demo.model.Recharge;
import com.example.demo.model.VipUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Z
 */

@Service
public class VipUserService {
    @Resource
    private VipUserDao vipUserDao;
    @Resource
    private RechargeDao rechargeDao;
    @Resource
    private ConsumptionDao consumptionDao;

    public List<VipUser> selectAll(VipUser vipUser){
        return vipUserDao.selectAll(vipUser);
    }

    public List<VipUser> selectByStatus(VipUser vipUser){
        return vipUserDao.selectByStatus(vipUser);
    }
    public  void  insert(VipUser vipUser){
        vipUserDao.insert(vipUser);
    }

    public  void  deletes(Long[] ids){
        vipUserDao.deletes(ids);
    }

    @Transactional(rollbackFor = Exception.class)
    public void recharge(VipUser vipUser){
        vipUserDao.recharge(vipUser);
        Recharge recharge = new Recharge();
        recharge.setUserId(vipUser.getId());
        recharge.setMoney(vipUser.getMoney());
        recharge.setName(vipUser.getName());
        recharge.setTime(DateUtil.today());
        recharge.setTime(DateUtil.now());
        rechargeDao.insertRecharge(recharge);
    }
    public void consume(VipUser vipUser){
        vipUserDao.consume(vipUser);
    }

    public  void cardLose(VipUser vipUser){
        vipUserDao.cardLose(vipUser);
    }

    public void userBuy(VipUser vipUser) {
        vipUserDao.userBuy(vipUser);
        Consumption consumption = new Consumption();
        consumption.setUserId(vipUser.getId());
        consumption.setMoney(vipUser.getMoney());
        consumption.setName(vipUser.getName());
        consumption.setTime(DateUtil.today());
        consumption.setTime(DateUtil.now());
        consumptionDao.insertConsumption(consumption);
    }

   public  void integralConvertible(VipUser vipUser){
        vipUserDao.integralConvertible(vipUser);
   }


    public void replaceCard(VipUser vipUser){
        vipUserDao.replaceCard(vipUser);
    }
}
