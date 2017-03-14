package com.voronovich.dao;

import com.voronovich.pojo.User;
import com.voronovich.exceptions.DaoException;

import java.util.List;

/**
 * Interface contains additional abstract methods
 * for User DAO layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface UserDao extends Dao<User> {

    /**
     * Returns the whole list of users
     *
     * @return List<User>
     * @throws DaoException
     */
    List<User> getAllUsers() throws DaoException;

    /**
     * Returns user by phone
     *
     * @return List<User>
     * @throws DaoException
     */
    User getByPhone(String phone) throws DaoException;

    /**
     * Returns user by email
     *
     * @return List<User>
     * @throws DaoException
     */
    User getByEmail(String email) throws DaoException;

    /**
     * Returns user by phone and password
     *
     * @return List<User>
     * @throws DaoException
     */
    User getByPhoneAndPassword(String phone, String password) throws DaoException;

    /**
     * Returns user by email and password
     *
     * @return List<User>
     * @throws DaoException
     */
    User getByEmailAndPassword(String email, String password) throws DaoException;
}
