package com.filesharesystem.dao.impl;

import com.filesharesystem.dao.BaseDAO;
import com.filesharesystem.utils.SessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.web.context.request.SessionScope;

import java.util.Set;

public class BaseDAOImpl implements BaseDAO {
    /**
     * 传入obj,根据obj的类型进行<b>保存和更改</b>
     *
     * @param obj
     * @return
     */
    @Override
    public boolean save_or_update(Object obj) {
        boolean ret = false;
        Session session = SessionUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(obj.getClass().getName(), obj);
            transaction.commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            // todo
            // session not equals null is always on ture.
            if (session != null) {
                SessionUtil.closeSession(session);
            }
        }

        return ret;
    }

    /**
     * 传入obj 根据obj的类型进行删除
     *
     * @param obj
     * @return
     */
    @Override
    public boolean delete(Object obj) {
        boolean ret = false;
        Session session = SessionUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(obj.getClass().getName(), obj);
            System.out.println(obj.getClass().getName());
            transaction.commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
//            session is always true. close session immediately.
//            SessionUtil.closeSession(session);
            if (session != null) {
                SessionUtil.closeSession(session);
            }
        }
        return ret;

    }

    /**
     * 根据 类型 和 serializeUID 进行获取<b>不常用</b>
     *
     * @param class_
     * @param name
     * @return
     */
    @Override
    public Object get_obj_or_null (Class class_, String name) {
        Session session = SessionUtil.openSession();
        Object obj = session.get(class_.getClass(), name);
        SessionUtil.closeSession(session);
        return obj;
    }
}
