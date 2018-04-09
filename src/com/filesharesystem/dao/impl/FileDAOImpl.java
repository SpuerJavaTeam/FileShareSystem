package com.filesharesystem.dao.impl;

import com.filesharesystem.dao.BaseDAO;
import com.filesharesystem.dao.FileDAO;
import com.filesharesystem.models.File;
import com.filesharesystem.utils.SessionUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class FileDAOImpl extends BaseDAOImpl implements FileDAO {

    @Override
    public List<File[]> queryByName(String name) {
        Session session = SessionUtil.openSession();
        Query query = session.createQuery("from file where File.username=:username")
                .setString("username", name);
        List<File[]> userList = query.list();
        return userList;
    }

    @Override
    public File getFile(String name) {
        File file = (File) getObject(File.class, name);
        return file;
    }

    public List<File> getFiles(){
        List<File> files= new ArrayList<File>();
        Session session = SessionUtil.openSession();
        Query query = session.createQuery("from file");
//        List<>
        // 添加获得文件列表方法
//        files = ;
        return files;
    }

}
