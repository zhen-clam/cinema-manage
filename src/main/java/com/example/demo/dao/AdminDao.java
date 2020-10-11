package com.example.demo.dao;

import com.example.demo.model.Admin;
import com.example.demo.model.VipUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Z
 */
@Mapper
public interface AdminDao {
    /**
     * 用户登录
     * @param admin
     * @return
     */
    Admin login(Admin admin);


    /*List<Admin> select(Admin admin);*/
}
