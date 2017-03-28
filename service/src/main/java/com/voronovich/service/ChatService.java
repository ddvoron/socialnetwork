package com.voronovich.service;

import com.voronovich.pojo.Chat;

import java.io.Serializable;
import java.util.List;

public interface ChatService {

    /**
     * Saves or updates chat
     *
     * @param chat Chat
     */
    void saveOrUpdate(Chat chat);

    /**
     * Removes chat
     *
     * @param chat Chat
     */
    void delete(Chat chat);

    /**
     * Reads chat
     *
     * @param id - chat id
     * @return Chat
     */
    Chat get(Serializable id);

    /**
     * Reads the whole list of chats
     *
     * @return List<Chat>
     */
    List<Chat> getAllChats();
}