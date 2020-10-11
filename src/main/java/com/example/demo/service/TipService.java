package com.example.demo.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dao.TipDao;
import com.example.demo.model.User;
import com.example.demo.model.UserBirth;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Z
 */
@Service
public class TipService {
    @Resource
    private TipDao tipDao;
    public static String today= DateUtil.today();

    /**
     * 获取用户
     * @param user
     * @param page
     * @param rows
     * @return
     */
    public Object selectAll(UserBirth user, Integer page, Integer rows) {
        Map<Object, Object> map = new HashMap<>();
        PageHelper.startPage(page,rows);
        List<UserBirth> users = tipDao.selectBirth(user);
        PageInfo<UserBirth> pageInfo = new PageInfo<>(users);
        map.put("total" , pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    /**
     * 会员生日提醒
     * @param user
     * @return
     */
    public Integer tip(User user) {
        if(user.getTip()!=null){
            //取消提醒
            if(user.getTip().equals("是")) {
                tipDao.updateTip(user);
                return 1;
            }
            //提醒
            else{
                tipDao.updateTip(user);
                return 2;
            }
        }
        return 0;
    }

    public Object search(UserBirth userDTO, Integer page, Integer rows) {
        Map<Object, Object> map = new HashMap<>();
        List<User> users=null;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        PageHelper.startPage(page,rows);
        //失误点
        if(null==userDTO.getSearchFuture()){
            Object o = selectAll(new UserBirth(), page, rows);
            return o;
        }
        if(userDTO.getSearchFuture().equals("未来三天")){
            //当前时间+3天
            Date date = DateUtil.parse(today);
            DateTime threeDay = DateUtil.offsetDay(date, 3);
            DateTime threeDay_end = DateUtil.offsetHour(threeDay, 1);
            wrapper.ge("birthday",today);
            wrapper.le("birthday",threeDay_end);
            users = tipDao.selectList(wrapper);
        }else{
            //当前时间+7天
            Date date = DateUtil.parse(today);
            DateTime threeDay = DateUtil.offsetDay(date, 7);
            DateTime threeDay_end = DateUtil.offsetHour(threeDay, 1);
            wrapper.ge("birthday",today);
            wrapper.le("birthday",threeDay_end);
            users = tipDao.selectList(wrapper);
        }
        PageInfo<User> pageInfo = new PageInfo<>(users);
        map.put("total" , pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
}
