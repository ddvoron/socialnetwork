package com.voronovich.service.impl;

import com.voronovich.dao.UserDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.User;
import com.voronovich.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao dao;

    @Override
    public void saveOrUpdate(User user){
        try {
            dao.saveOrUpdate(user);
        } catch (DaoException e) {
            log.error("Error in saveOrUpdate(User user) ",e);
        }
    }

    @Override
    public void delete(User user){
        try {
            dao.delete(user);
        } catch (DaoException e) {
            log.error("Error in delete(User user) ",e);
        }
    }

    @Override
    public User get(Serializable id){
        try {
            return dao.get(id);
        } catch (DaoException e) {
            log.error("Error in User get(Serializable id) ",e);
        }
        return null;
    }

    @Override
    public List<User> getAllUsers(){
        try {
            return dao.getAllUsers();
        } catch (DaoException e) {
            log.error("Error in List<User> getAllUsers() ",e);
        }
        return null;
    }

    @Override
    public User getByPhone(String phone){
        try {
            return dao.getByPhone(phone);
        } catch (DaoException e) {
            log.error("Error in User getByPhone(String phone) ",e);
        }
        return null;
    }

    @Override
    public User getByEmail(String email){
        try {
            return dao.getByEmail(email);
        } catch (DaoException e) {
            log.error("Error in User getByEmail(String email) ",e);
        }
        return null;
    }

    @Override
    public User getByPhoneAndPassword(String phone, String password){
        try {
            return dao.getByPhoneAndPassword(phone, password);
        } catch (DaoException e) {
            log.error("Error in User getByPhoneAndPassword(String phone, String password) ",e);
        }
        return null;
    }

    @Override
    public User getByEmailAndPassword(String email, String password){
        try {
            return dao.getByEmailAndPassword(email, password);
        } catch (DaoException e) {
            log.error("Error in User getByEmailAndPassword(String email, String password) ",e);

        }
        return null;
    }
}
