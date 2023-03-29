package com.city.erp.factory;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateFactory {
    private static SessionFactory sf=null;
    static {
        Configuration cfg=new Configuration();
        cfg.configure();//读取配置文件hibernate.cfg.xml
        sf=cfg.buildSessionFactory();
    }

    public static SessionFactory getSF() {
        return sf;
    }

    public static Session openSession() {
        return sf.openSession();
    }
}
