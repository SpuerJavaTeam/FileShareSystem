package com.filesharesystem.dao.impl;

import com.filesharesystem.dao.BaseDAO;
import com.filesharesystem.dao.FileDAO;
import com.filesharesystem.models.File;
import com.filesharesystem.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class FileDAOImpl extends BaseDAOImpl implements FileDAO {

    @Override
    public List<File> queryByName(String name) {
        Session session = SessionUtil.openSession();
        List<File> userList = session.createQuery("from File where File.username=:username").setString("username", name).list();
        return userList;
    }

    @Override
    public File getFile(String name) {
        File file = (File) get_obj_or_null(File.class, name);
        return file;
    }
}
