package com.filesharesystem.dao.impl;

import com.filesharesystem.dao.UserDAO;
import com.filesharesystem.models.User;
import com.filesharesystem.utils.SessionUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class UserDAOImpl extends BaseDAOImpl implements UserDAO {

    /**
     * 列出所有名字相同的用户
     *
     * @param name
     * @return
     */
    @Override
    public List<User> queryByName(String name) {
        Session session = SessionUtil.openSession();
        List<User> users = session.createQuery("from User where User.username=:username").setString("username", name).list();
        return users;
    }

    /**
     * 验证user，如果不对则返回null
     *
     * @param name
     * @return
     */
    @Override
    public User getUser(String name) {
        Session session = SessionUtil.openSession();
        List<User> users = session.createQuery("from User as u where u.username=:name").setString("name", name).list();
        if (user.isEmpty()) {
            return null;
        } else {
            return users.get(0);
        }
    }
}
