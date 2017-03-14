package com.voronovich.dao.impl;

import com.voronovich.dao.MessageDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Message;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDaoImpl extends DaoImpl<Message> implements MessageDao {

    private Logger log = Logger.getLogger(MessageDaoImpl.class);

    @Autowired
    public MessageDaoImpl(SessionFactory sessionFactory){
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Message> getAllMessages() throws DaoException {
        List<Message> messages;
        try {
            Query query = getSession().getNamedQuery("getAllMessages");
            messages =  query.list();
            log.info("Got all messages: " + messages);
            return messages;
        } catch (HibernateException e) {
            log.error("Error getting all messages " + e);
            throw new DaoException(e);
        }
    }
}

