package com.example.demo.dao;


import com.example.demo.model.Recharge;
import com.example.demo.model.User;

import java.util.List;

/**
 * @author Z
 */
public interface RechargeDao {


    /**
     * 充值记录
     * @param recharge
     */
    void insertRecharge(Recharge recharge);

    /**
     * 删除充值记录
     * @param ids
     */
    void deleteRecharge(Long[] ids);

    /**
     * 显示所有充值记录
     * @param recharge
     * @return
     */

    List<Recharge> selectList(Recharge recharge);
}
