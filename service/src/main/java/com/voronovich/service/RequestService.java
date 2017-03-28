package com.voronovich.service;

import com.voronovich.pojo.Request;

import java.io.Serializable;
import java.util.List;

public interface RequestService {

    /**
     * Saves or updates request
     *
     * @param request Request
     */
    void saveOrUpdate(Request request);

    /**
     * Removes request
     *
     * @param request Request
     */
    void delete(Request request);

    /**
     * Reads request
     *
     * @param id - request id
     * @return Request
     */
    Request get(Serializable id);

    /**
     * Reads the whole list of requests
     *
     * @return List<Request>
     */
    List<Request> getAllRequests();
}