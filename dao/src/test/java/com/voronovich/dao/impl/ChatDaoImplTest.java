package com.voronovich.dao.impl;

import com.voronovich.dao.ChatDao;
import com.voronovich.dao.UserDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Chat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration("/beans-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
public class ChatDaoImplTest {

    @Autowired
    private ChatDao chatDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void saveChat() throws DaoException {
        Chat chat = new Chat(0, userDao.get(1), userDao.get(2));
        List<Chat> before = chatDao.getAllChats();
        int sizeBefore = before.size();
        chatDao.saveOrUpdate(chat);
        List<Chat> after = chatDao.getAllChats();
        int sizeAfter = after.size();
        Assert.assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getChatById() throws DaoException {
        Chat chat = chatDao.get(1);
        Assert.assertEquals("Not got", userDao.get(1), chat.getUserOne());
    }

    @Test
    public void deleteChat() throws DaoException {
        List<Chat> before = chatDao.getAllChats();
        int sizeBefore = before.size();
        Chat chat = chatDao.get(1);
        chatDao.delete(chat);
        List<Chat> after = chatDao.getAllChats();
        int sizeAfter = after.size();
        Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
