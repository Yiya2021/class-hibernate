package com.city.erp.service.impl;

import com.city.erp.factory.HibernateFactory;
import com.city.erp.model.ProductModel;
import com.city.erp.service.IProductService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProductServiceImpl implements IProductService {

    SessionFactory sf = HibernateFactory.getSF();

    @Override
    public int add(ProductModel pm) throws Exception {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(pm);
        //更新外键
        pm.getPackagingModel().setPno(pm.getPno());
        session.save(pm.getPackagingModel());
        session.getTransaction().commit();
        session.close();
        return pm.getPno();
    }

    @Override
    public void addArea(int productNo, int areaNo) throws Exception {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(productNo);
        session.save(areaNo);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void addAreas(int productNo, int[] areaNos) throws Exception {
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(productNo);
        session.save(areaNos);
        session.getTransaction().commit();
        session.close();
    }
}
