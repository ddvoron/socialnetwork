package com.voronovich.dao.impl;

import com.voronovich.dao.RoleDao;
import com.voronovich.dao.UserDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.User;
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
public class UserDaoImplTest {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Test
    public void saveUser() throws DaoException {
        User user = new User(0, "test", "test", "test@mail.ru", "test", "test", "test", "test", roleDao.get(10));
        List<User> before = userDao.getAllUsers();
        int sizeBefore = before.size();
        userDao.saveOrUpdate(user);
        List<User> after = userDao.getAllUsers();
        int sizeAfter = after.size();
        Assert.assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getUserById() throws DaoException {
        User user = userDao.get(1);
        Assert.assertEquals("Not got", "test1", user.getName());
    }

    @Test
    public void deleteRole() throws DaoException {
        List<User> before = userDao.getAllUsers();
        int sizeBefore = before.size();
        User user = userDao.get(1);
        userDao.delete(user);
        List<User> after = userDao.getAllUsers();
        int sizeAfter = after.size();
        Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
