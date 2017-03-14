package com.voronovich.dao;

import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Message;

import java.util.List;

/**
 * Interface contains additional abstract methods
 * for Message DAO layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface MessageDao extends Dao<Message> {

    /**
     * Method reads the whole list of messages
     *
     * @return List<Message>
     * @throws DaoException
     */
    List<Message> getAllMessages() throws DaoException;
}
