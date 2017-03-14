package com.voronovich.dao.impl;

import com.voronovich.dao.UserDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends DaoImpl<User> implements UserDao {

    private Logger log = Logger.getLogger(UserDaoImpl.class);

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUsers() throws DaoException {
        try {
            Query query = getSession().getNamedQuery("getAllUsers");
            List<User> users =  query.list();
            log.info("Got all users :" + users);
            return users;
        } catch (HibernateException e) {
            log.error("Error getting all users " + e);
            throw new DaoException(e);
        }
    }

    @Override
    public User getByPhone(String phone) throws DaoException {
        try{
            Query query = getSession().getNamedQuery("getUserByPhone");
            User user = (User) query.uniqueResult();
            log.info("got user by phone :" + user);
            return user;
        } catch (HibernateException e) {
            log.error("Error getting user by phone " + e);
            throw new DaoException(e);
        }
    }

    @Override
    public User getByEmail(String email) throws DaoException {
        try{
            Query query = getSession().getNamedQuery("getUserByEmail");
            User user = (User) query.uniqueResult();
            log.info("got user by email :" + user);
            return user;
        } catch (HibernateException e) {
            log.error("Error getting user by email " + e);
            throw new DaoException(e);
        }
    }

    @Override
    public User getByPhoneAndPassword(String phone, String password) throws DaoException {
        try{
            Query query = getSession().getNamedQuery("getUserByPhoneAndPassword");
            User user = (User) query.uniqueResult();
            log.info("got user by phone and password :" + user);
            return user;
        } catch (HibernateException e) {
            log.error("Error getting user by phone and password " + e);
            throw new DaoException(e);
        }
    }

    @Override
    public User getByEmailAndPassword(String email, String password) throws DaoException {
        try{
            Query query = getSession().getNamedQuery("getUserByEmailAndPassword");
            User user = (User) query.uniqueResult();
            log.info("got user by email and password :" + user);
            return user;
        } catch (HibernateException e) {
            log.error("Error getting user by email and password " + e);
            throw new DaoException(e);
        }
    }
}

