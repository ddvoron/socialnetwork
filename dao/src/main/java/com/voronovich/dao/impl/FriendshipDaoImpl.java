package com.voronovich.dao.impl;

import com.voronovich.dao.FriendshipDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Friendship;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FriendshipDaoImpl extends DaoImpl<Friendship> implements FriendshipDao {

    private Logger log = Logger.getLogger(FriendshipDaoImpl.class);

    @Autowired
    public FriendshipDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Friendship> getAllFriendships() throws DaoException {
        List<Friendship> friendships;
        try {
            Query query = getSession().getNamedQuery("getAllFriendships");
            friendships =  query.list();
            log.info("Got all friendships: " + friendships);
            return friendships;
        } catch (HibernateException e) {
            log.error("Error getting all friendships " + e);
            throw new DaoException(e);
        }
    }
}

