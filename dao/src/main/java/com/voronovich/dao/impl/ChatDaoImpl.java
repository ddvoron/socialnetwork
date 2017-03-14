package com.voronovich.dao.impl;

import com.voronovich.dao.ChatDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Chat;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ChatDaoImpl extends DaoImpl<Chat> implements ChatDao {

    private Logger log = Logger.getLogger(ChatDaoImpl.class);

    @Autowired
    public ChatDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Chat> getAllChats() throws DaoException {
        List<Chat> chats;
        try {
            Query query = getSession().getNamedQuery("getAllChats");
            chats =  query.list();
            log.info("Got all chats: " + chats);
            return chats;
        } catch (HibernateException e) {
            log.error("Error getting all chats " + e);
            throw new DaoException(e);
        }
    }
}

