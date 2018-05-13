package com.shsxt.xmjf.server.db.dao;

import com.shsxt.xmjf.api.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by lp on 2018/5/11.
 */
public interface UserDao {

    public User queryUserById(@Param("userId")Integer userId);
}
