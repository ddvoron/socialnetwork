package com.voronovich.service;

import com.voronovich.exceptions.ServiceException;
import com.voronovich.pojo.Chat;

import java.io.Serializable;
import java.util.List;

public interface ChatService {

    /**
     * Saves or updates chat
     *
     * @param chat Chat
     */
    void saveOrUpdate(Chat chat) throws ServiceException;

    /**
     * Removes chat
     *
     * @param chat Chat
     */
    void delete(Chat chat) throws ServiceException;

    /**
     * Reads chat
     *
     * @param id - chat id
     * @return Chat
     */
    Chat get(Serializable id) throws ServiceException;

    /**
     * Reads the whole list of chats
     *
     * @return List<Chat>
     */
    List<Chat> getAllChats() throws ServiceException;
}