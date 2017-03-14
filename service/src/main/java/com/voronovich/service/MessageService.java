package com.voronovich.service;

import com.voronovich.exceptions.ServiceException;
import com.voronovich.pojo.Message;

import java.io.Serializable;
import java.util.List;

public interface MessageService {

    /**
     * Saves or updates message
     *
     * @param message Message
     */
    void saveOrUpdate(Message message) throws ServiceException;

    /**
     * Removes message
     *
     * @param message Message
     */
    void delete(Message message) throws ServiceException;

    /**
     * Reads message
     *
     * @param id - message id
     * @return Message
     */
    Message get(Serializable id) throws ServiceException;

    /**
     * Reads the whole list of messages
     *
     * @return List<Message>
     */
    List<Message> getAllMessages() throws ServiceException;
}
