package com.filesharesystem.dao;

public interface BaseDAO {
    boolean save_or_update(Object obj);

    boolean delete(Object obj);

    Object get_obj_or_null(Class class_, String name);
}
