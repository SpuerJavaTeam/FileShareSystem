package com.filesharesystem.dao;

import com.filesharesystem.models.User;
import com.filesharesystem.models.UserData;

public interface UserDataDAO extends BaseDAO {
    UserData getUserData(String uid);

    UserData delete(UserData userData);

    UserData saveOrUpdate(UserData userData);
}
