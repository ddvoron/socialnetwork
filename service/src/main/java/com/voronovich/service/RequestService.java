package com.voronovich.service;

import com.voronovich.exceptions.ServiceException;
import com.voronovich.pojo.Request;

import java.io.Serializable;
import java.util.List;

public interface RequestService {

    /**
     * Saves or updates request
     *
     * @param request Request
     */
    void saveOrUpdate(Request request) throws ServiceException;

    /**
     * Removes request
     *
     * @param request Request
     */
    void delete(Request request) throws ServiceException;

    /**
     * Reads request
     *
     * @param id - request id
     * @return Request
     */
    Request get(Serializable id) throws ServiceException;

    /**
     * Reads the whole list of requests
     *
     * @return List<Request>
     */
    List<Request> getAllRequests() throws ServiceException;
}