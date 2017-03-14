package com.voronovich.service.impl;

import com.voronovich.dao.MessageDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.exceptions.ServiceException;
import com.voronovich.pojo.Message;
import com.voronovich.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao dao;

    @Override
    public void saveOrUpdate(Message message) throws ServiceException{
        try {
            dao.saveOrUpdate(message);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Message message) throws ServiceException{
        try {
            dao.delete(message);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Message get(Serializable id) throws ServiceException{
        try {
            return dao.get(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Message> getAllMessages() throws ServiceException{
        try {
            return dao.getAllMessages();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
