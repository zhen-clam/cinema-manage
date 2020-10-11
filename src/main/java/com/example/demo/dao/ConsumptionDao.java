package com.example.demo.dao;


import com.example.demo.model.Consumption;
import com.example.demo.model.Recharge;

import java.util.List;

/**
 * @author Z
 */
public interface ConsumptionDao {
    /**
     * 消费记录
     * @param consumption
     */
    void insertConsumption(Consumption consumption);

    /**
     * 显示所有消费记录
     * @param consumption
     * @return
     */
    List<Consumption> selectConsumption(Consumption consumption);

    /**
     * 删除消费记录
     * @param ids
     */

    void deleteConsumption(Long[] ids);

}
