package com.voronovich.service;

import com.voronovich.exceptions.ServiceException;
import com.voronovich.pojo.Friendship;

import java.io.Serializable;
import java.util.List;

public interface FriendshipService {

    /**
     * Saves or updates friendship
     *
     * @param friendship Friendship
     */
    void saveOrUpdate(Friendship friendship) throws ServiceException;

    /**
     * Removes friendship
     *
     * @param friendship Friendship
     */
    void delete(Friendship friendship) throws ServiceException;

    /**
     * Reads friendship
     *
     * @param id - friendship id
     * @return Friendship
     */
    Friendship get(Serializable id) throws ServiceException;

    /**
     * Reads the whole list of friendships
     *
     * @return List<Friendship>
     */
    List<Friendship> getAllFriendships() throws ServiceException;
}