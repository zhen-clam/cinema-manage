package com.example.demo.service;

import com.example.demo.dao.AdminDao;
import com.example.demo.model.Admin;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Z
 */
@Service
public class AdminService  {
    @Resource
    private AdminDao adminDao;

    public Admin adminLogin(Admin admin){
        return  adminDao.login(admin);
    }

    /*public List<Admin> select(Admin admin){
        return adminDao.select(admin);
    }*/

}
