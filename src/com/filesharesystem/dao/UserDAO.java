package com.filesharesystem.dao;

import com.filesharesystem.models.User;

import java.util.List;

public interface UserDAO extends BaseDAO {
    User getUserByID(String id);

    User getUser(String name);

    List<User> queryByName(String name);

    Boolean delete(User user);

    Boolean update(User user);
}
