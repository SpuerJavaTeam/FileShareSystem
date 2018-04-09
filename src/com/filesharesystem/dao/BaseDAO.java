package com.filesharesystem.dao;

public interface BaseDAO {
    boolean saveOrUpdate(Object obj);

    boolean delete(Object obj);

    Object getObject(Class class_, String name);
}
