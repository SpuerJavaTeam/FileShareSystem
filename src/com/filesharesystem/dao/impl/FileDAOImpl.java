package com.filesharesystem.dao.impl;

import com.filesharesystem.dao.BaseDAO;
import com.filesharesystem.dao.FileDAO;
import com.filesharesystem.models.File;
import com.filesharesystem.utils.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

public class FileDAOImpl extends BaseDAOImpl implements FileDAO {


    public List<File> getFiles(){
        Session session = null;
        Transaction transaction = null;
        List<File> files = null;
        try {
            session = SessionUtil.openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(File.class);
            files = criteria.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return files;
    }

    public List<File> getFileById(String uid){
        Session session = null;
        Transaction transaction = null;
        List<File> files = null;
        try {
            session = SessionUtil.openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(File.class);
            criteria.add(Restrictions.eq("uid", uid));
            files = criteria.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return files;
    }
}
