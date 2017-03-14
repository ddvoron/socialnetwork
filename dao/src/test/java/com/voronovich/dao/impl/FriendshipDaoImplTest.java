package com.voronovich.dao.impl;

import com.voronovich.dao.FriendshipDao;
import com.voronovich.dao.UserDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Friendship;
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
public class FriendshipDaoImplTest {

    @Autowired
    private FriendshipDao friendshipDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void saveFriendship() throws DaoException {
        Friendship friendship = new Friendship(0, userDao.get(1), userDao.get(2));
        List<Friendship> before = friendshipDao.getAllFriendships();
        int sizeBefore = before.size();
        friendshipDao.saveOrUpdate(friendship);
        List<Friendship> after = friendshipDao.getAllFriendships();
        int sizeAfter = after.size();
        Assert.assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getFriendshipById() throws DaoException {
        Friendship friendship = friendshipDao.get(1);
        Assert.assertEquals("Not got", userDao.get(1), friendship.getFriendOne());
    }

    @Test
    public void deleteFriendship() throws DaoException {
        List<Friendship> before = friendshipDao.getAllFriendships();
        int sizeBefore = before.size();
        Friendship friendship = friendshipDao.get(1);
        friendshipDao.delete(friendship);
        List<Friendship> after = friendshipDao.getAllFriendships();
        int sizeAfter = after.size();
        Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
