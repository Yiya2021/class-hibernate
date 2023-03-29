package com.city.erp.service.impl;

import com.city.erp.factory.HibernateFactory;
import com.city.erp.model.AreaModel;
import com.city.erp.service.IAreaService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AreaServiceImpl implements IAreaService {
    SessionFactory sf = HibernateFactory.getSF();
    @Override
    public List<AreaModel> getListByAll() throws Exception {
        Session session = sf.openSession();
        session.beginTransaction();
        List<AreaModel> list = session.createQuery("from AreaModel", AreaModel.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return list;
    }
}
