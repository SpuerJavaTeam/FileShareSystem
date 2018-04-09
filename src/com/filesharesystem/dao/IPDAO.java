package com.filesharesystem.dao;

import com.filesharesystem.models.IP;

public interface IPDAO extends BaseDAO {
    //TODO：见models.IP
    boolean saveOrUpdate(IP ip);
}
