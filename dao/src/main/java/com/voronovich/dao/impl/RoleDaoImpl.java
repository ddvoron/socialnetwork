package com.voronovich.dao.impl;

import com.voronovich.dao.RoleDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Role;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl extends DaoImpl<Role> implements RoleDao {

    private Logger log = Logger.getLogger(RoleDaoImpl.class);

    @Autowired
    public RoleDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Role> getAllRoles() throws DaoException {
        List<Role> roles;
        try {
            Query query = getSession().getNamedQuery("getAllRoles");
            roles =  query.list();
            log.info("Got all roles: " + roles);
            return roles;
        } catch (HibernateException e) {
            log.error("Error getting all roles " + e);
            throw new DaoException(e);
        }
    }
}

