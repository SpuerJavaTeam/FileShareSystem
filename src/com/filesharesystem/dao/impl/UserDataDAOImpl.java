package com.filesharesystem.dao.impl;

import com.filesharesystem.dao.BaseDAO;
import com.filesharesystem.dao.UserDataDAO;
import com.filesharesystem.models.UserData;
import com.filesharesystem.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDataDAOImpl extends BaseDAOImpl implements UserDataDAO {


    @Override
    public UserData getUserData(String uid) {
        Session session = SessionUtil.openSession();
        UserData userData = (UserData) session.get(UserData.class, uid);
        return userData;
    }
}
