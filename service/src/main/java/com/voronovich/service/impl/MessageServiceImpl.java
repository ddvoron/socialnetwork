package com.voronovich.service.impl;

import com.voronovich.dao.MessageDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Message;
import com.voronovich.service.MessageService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private static Logger log = Logger.getLogger(MessageServiceImpl.class);

    @Autowired
    private MessageDao dao;

    @Override
    public void saveOrUpdate(Message message){
        try {
            dao.saveOrUpdate(message);
        } catch (DaoException e) {
            log.error("Error in saveOrUpdate(Message message) ",e);
        }
    }

    @Override
    public void delete(Message message){
        try {
            dao.delete(message);
        } catch (DaoException e) {
            log.error("Error in delete(Message message) ",e);
        }
    }

    @Override
    public Message get(Serializable id){
        try {
            return dao.get(id);
        } catch (DaoException e) {
            log.error("Error in Message get(Serializable id) ",e);
        }
        return null;
    }

    @Override
    public List<Message> getAllMessages(){
        try {
            return dao.getAllMessages();
        } catch (DaoException e) {
            log.error("Error in List<Message> getAllMessages() ",e);
        }
        return null;
    }
}
