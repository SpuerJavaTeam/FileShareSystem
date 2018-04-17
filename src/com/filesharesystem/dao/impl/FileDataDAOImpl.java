package com.filesharesystem.dao.impl;

import com.filesharesystem.dao.BaseDAO;
import com.filesharesystem.dao.FileDataDAO;
import com.filesharesystem.models.File;
import com.filesharesystem.models.FileData;
import com.filesharesystem.utils.SessionUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class FileDataDAOImpl extends BaseDAOImpl implements FileDataDAO {
    // BaseDAO默认方法即可
    @Override
    public List<FileData> getFileDateByFID(String fid){
        Session session = null;
        Transaction transaction = null;
        List<FileData> fileData = null;
        try {
            session = SessionUtil.openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(FileData.class);
            criteria.add(Restrictions.eq("fid", fid));
            fileData = criteria.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session !=null) {
                session.close();
            }
        }
        return fileData;
    }

    @Override
    public FileData getFavoriteFileDate(String fid, String uid){
        Session session = null;
        Transaction transaction = null;
        List<FileData> fileData = null;
        try {
            session = SessionUtil.openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(FileData.class);
            criteria.add(Restrictions.eq("fid",fid));
            criteria.add(Restrictions.eq("visitorid", uid));
            criteria.add(Restrictions.eq("type", 2));
            fileData = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return fileData.get(0);
    }

    public List<FileData> getFileDateByUid(String uid){
        Session session = null;
        Transaction transaction = null;
        List<FileData> fileDataList = null;
        try {
            session = SessionUtil.openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(FileData.class);
            criteria.add(Restrictions.eq("uid", uid));
            criteria.createCriteria("fid");
            fileDataList = criteria.list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if (session != null){
                session.close();
            }
        }
        return fileDataList;
    }
}
