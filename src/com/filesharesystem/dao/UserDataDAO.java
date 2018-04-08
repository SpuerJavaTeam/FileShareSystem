package com.filesharesystem.dao;

import com.filesharesystem.models.UserData;

public interface UserDataDAO extends BaseDAO {
    UserData getUserData(String uid);
}
