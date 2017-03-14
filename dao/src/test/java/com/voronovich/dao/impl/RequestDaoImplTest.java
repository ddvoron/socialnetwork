package com.voronovich.dao.impl;

import com.voronovich.dao.RequestDao;
import com.voronovich.dao.UserDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Request;
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
public class RequestDaoImplTest {

    @Autowired
    private RequestDao requestDao;

    @Autowired
    private UserDao userDao;

    @Test
    public void saveRequest() throws DaoException {
        Request request = new Request(0, userDao.get(1), userDao.get(2), "true");
        List<Request> before = requestDao.getAllRequests();
        int sizeBefore = before.size();
        requestDao.saveOrUpdate(request);
        List<Request> after = requestDao.getAllRequests();
        int sizeAfter = after.size();
        Assert.assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getRequestById() throws DaoException {
        Request request = requestDao.get(1);
        Assert.assertEquals("Not got", userDao.get(1), request.getSender());
    }

    @Test
    public void deleteRequest() throws DaoException {
        List<Request> before = requestDao.getAllRequests();
        int sizeBefore = before.size();
        Request request = requestDao.get(1);
        requestDao.delete(request);
        List<Request> after = requestDao.getAllRequests();
        int sizeAfter = after.size();
        Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
