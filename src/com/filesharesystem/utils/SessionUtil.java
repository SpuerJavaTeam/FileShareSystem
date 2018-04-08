package com.filesharesystem.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

// TODO: 思考是使用BaseDAO还是创建Utils？
// 使用Utils,创建工厂，保持DAO层的整洁
public class SessionUtil {
    private static SessionFactory factory;

    static {
        Configuration configuration = new org.hibernate.cfg.Configuration().configure("h.cfg.xml");
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .buildServiceRegistry();
        factory = configuration.buildSessionFactory(serviceRegistry);
    }

    public static Session openSession() {
        Session session = factory.openSession();
        return session;
    }

    public static void closeSession(Session session) {
        if (session != null) {
            session.close();
        } else {
            // TODO: log here
        }
    }
}
