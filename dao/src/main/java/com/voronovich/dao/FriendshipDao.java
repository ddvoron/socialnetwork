package com.voronovich.dao;

import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Friendship;

import java.util.List;

/**
 * Interface contains additional abstract methods
 * for Friendship DAO layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface FriendshipDao extends Dao<Friendship> {

    /**
     * Method reads the whole list of friendships
     *
     * @return List<Friendship>
     * @throws DaoException
     */
    List<Friendship> getAllFriendships() throws DaoException;
}
