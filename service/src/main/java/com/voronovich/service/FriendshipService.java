package com.voronovich.service;

import com.voronovich.pojo.Friendship;

import java.io.Serializable;
import java.util.List;

public interface FriendshipService {

    /**
     * Saves or updates friendship
     *
     * @param friendship Friendship
     */
    void saveOrUpdate(Friendship friendship);

    /**
     * Removes friendship
     *
     * @param friendship Friendship
     */
    void delete(Friendship friendship);

    /**
     * Reads friendship
     *
     * @param id - friendship id
     * @return Friendship
     */
    Friendship get(Serializable id);

    /**
     * Reads the whole list of friendships
     *
     * @return List<Friendship>
     */
    List<Friendship> getAllFriendships();
}