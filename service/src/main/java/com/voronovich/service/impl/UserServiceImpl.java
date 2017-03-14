package com.voronovich.service.impl;

import com.voronovich.dao.UserDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.exceptions.ServiceException;
import com.voronovich.pojo.User;
import com.voronovich.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public void saveOrUpdate(User user) throws ServiceException {
        try {
            dao.saveOrUpdate(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(User user) throws ServiceException {
        try {
            dao.delete(user);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User get(Serializable id) throws ServiceException {
        try {
            return dao.get(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<User> getAllUsers() throws ServiceException {
        try {
            return dao.getAllUsers();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User getByPhone(String phone) throws ServiceException {
        try {
            return dao.getByPhone(phone);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User getByEmail(String email) throws ServiceException {
        try {
            return dao.getByPhone(email);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User getByPhoneAndPassword(String phone, String password) throws ServiceException {
        try {
            return dao.getByPhoneAndPassword(phone, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public User getByEmailAndPassword(String email, String password) throws ServiceException {
        try {
            return dao.getByEmailAndPassword(email, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
