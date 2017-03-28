package com.voronovich.service.impl;

import com.voronovich.dao.ChatDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Chat;
import com.voronovich.service.ChatService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {

    private static Logger log = Logger.getLogger(ChatServiceImpl.class);

    @Autowired
    private ChatDao dao;

    @Override
    public void saveOrUpdate(Chat chat){
        try {
            dao.saveOrUpdate(chat);
        } catch (DaoException e) {
            log.error("Error in saveOrUpdate(Chat chat) ",e);
        }
    }

    @Override
    public void delete(Chat chat){
        try {
            dao.delete(chat);
        } catch (DaoException e) {
            log.error("Error in delete(Chat chat) ",e);
        }
    }

    @Override
    public Chat get(Serializable id){
        try {
            return dao.get(id);
        } catch (DaoException e) {
            log.error("Error in Chat get(Serializable id) ",e);
        }
        return null;
    }

    @Override
    public List<Chat> getAllChats(){
        try {
            return dao.getAllChats();
        } catch (DaoException e) {
            log.error("Error in List<Chat> getAllChats() ",e);
        }
        return null;
    }
}
