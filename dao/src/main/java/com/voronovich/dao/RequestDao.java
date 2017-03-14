package com.voronovich.dao;

import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Request;

import java.util.List;

/**
 * Interface contains additional abstract methods
 * for Request DAO layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface RequestDao extends Dao<Request> {

    /**
     * Method reads the whole list of requests
     *
     * @return List<Request>
     * @throws DaoException
     */
    List<Request> getAllRequests() throws DaoException;
}
