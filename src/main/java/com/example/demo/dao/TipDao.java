package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserBirth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Z
 */
@Mapper
public interface TipDao extends BaseMapper<User>{

    /**
     * 显示所有用户信息
     * @param userBirth
     * @return
     */
    List<UserBirth> selectBirth(UserBirth userBirth);

    /**
     * 更新提示状态
     * @param user
     */

    void updateTip(User user);

/*    void selectSevenBirth(UserBirth userBirth);

    void selectThreeBirth(UserBirth userBirth);*/
}
