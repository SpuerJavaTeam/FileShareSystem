package com.filesharesystem.dao.impl;

import com.filesharesystem.dao.IPDAO;
import com.filesharesystem.models.IP;
import com.filesharesystem.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class IPDAOImpl extends BaseDAOImpl implements IPDAO {
//TODO：见models.IP

    @Override
    public boolean saveOrUpdate(IP ip) {
        boolean ret = false;
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.openSession();
            transaction = session.beginTransaction();
            session.save(ip);
            transaction.commit();
            ret = true;
        } catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
        } finally {
            if( session != null) {
                session.close();
            }
        }
        return ret;
    }
}
