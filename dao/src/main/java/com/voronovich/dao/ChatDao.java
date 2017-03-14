package com.voronovich.dao;

import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Chat;

import java.util.List;

/**
 * Interface contains additional abstract methods
 * for Chat DAO layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface ChatDao extends Dao<Chat> {

    /**
     * Method reads the whole list of chats
     *
     * @return List<Chat>
     * @throws DaoException
     */
    List<Chat> getAllChats() throws DaoException;
}
