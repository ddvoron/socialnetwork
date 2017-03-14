package com.voronovich.dao.impl;

import com.voronovich.dao.RequestDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Request;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestDaoImpl extends DaoImpl<Request> implements RequestDao {

    private Logger log = Logger.getLogger(RequestDaoImpl.class);

    @Autowired
    public RequestDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Request> getAllRequests() throws DaoException {
        List<Request> requests;
        try {
            Query query = getSession().getNamedQuery("getAllRequests");
            requests =  query.list();
            log.info("Got all requests: " + requests);
            return requests;
        } catch (HibernateException e) {
            log.error("Error getting all requests " + e);
            throw new DaoException(e);
        }
    }
}

