package com.voronovich.dao.impl;

import com.voronovich.dao.MessageDao;
import com.voronovich.dao.ChatDao;
import com.voronovich.dao.UserDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Message;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@ContextConfiguration("/beans-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
public class MessageDaoImplTest {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private ChatDao chatDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void saveMessage() throws DaoException {
        Message message = new Message(0, userDao.get(1), userDao.get(2), "test", new Date(), chatDao.get(1));
        List<Message> before = messageDao.getAllMessages();
        int sizeBefore = before.size();
        messageDao.saveOrUpdate(message);
        List<Message> after = messageDao.getAllMessages();
        int sizeAfter = after.size();
        Assert.assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getMessageById() throws DaoException {
        Message message = messageDao.get(1);
        Assert.assertEquals("Not got", userDao.get(1), message.getUserOne());
    }

    @Test
    public void deleteMessage() throws DaoException {
        List<Message> before = messageDao.getAllMessages();
        int sizeBefore = before.size();
        Message message = messageDao.get(1);
        messageDao.delete(message);
        List<Message> after = messageDao.getAllMessages();
        int sizeAfter = after.size();
        Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
