package com.voronovich.service;

import com.voronovich.exceptions.ServiceException;
import com.voronovich.pojo.User;

import java.io.Serializable;
import java.util.List;

public interface UserService {

    /**
     * Saves or updates user
     *
     * @param  user User
     */
    void saveOrUpdate(User user) throws ServiceException;

    /**
     * Removes user
     *
     * @param user User
     */
    void delete(User user) throws ServiceException;

    /**
     * Reads user
     *
     * @param id - user id
     * @return User
     */
    User get(Serializable id) throws ServiceException;

    /**
     * Returns the whole list of users
     *
     * @return List<User>
     */
    List<User> getAllUsers() throws ServiceException;

    /**
     * Returns user by phone
     *
     * @return List<User>
     * @throws ServiceException
     */
    User getByPhone(String phone) throws ServiceException;

    /**
     * Returns user by email
     *
     * @return List<User>
     * @throws ServiceException
     */
    User getByEmail(String email) throws ServiceException;

    /**
     * Returns user by phone and password
     *
     * @return List<User>
     * @throws ServiceException
     */
    User getByPhoneAndPassword(String phone, String password) throws ServiceException;

    /**
     * Returns user by email and password
     *
     * @return List<User>
     * @throws ServiceException
     */
    User getByEmailAndPassword(String email, String password) throws ServiceException;
}

