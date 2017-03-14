package com.voronovich.service.impl;

import com.voronovich.dao.ChatDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.exceptions.ServiceException;
import com.voronovich.pojo.Chat;
import com.voronovich.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class ChatServiceImpl implements ChatService {

    @Autowired
    private ChatDao dao;

    @Override
    public void saveOrUpdate(Chat chat) throws ServiceException{
        try {
            dao.saveOrUpdate(chat);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Chat chat) throws ServiceException{
        try {
            dao.delete(chat);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Chat get(Serializable id) throws ServiceException{
        try {
            return dao.get(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Chat> getAllChats() throws ServiceException{
        try {
            return dao.getAllChats();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
