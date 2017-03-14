package com.voronovich.service.impl;

import com.voronovich.dao.RequestDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.exceptions.ServiceException;
import com.voronovich.pojo.Request;
import com.voronovich.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDao dao;

    @Override
    public void saveOrUpdate(Request request) throws ServiceException{
        try {
            dao.saveOrUpdate(request);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Request request) throws ServiceException{
        try {
            dao.delete(request);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Request get(Serializable id) throws ServiceException{
        try {
            return dao.get(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Request> getAllRequests() throws ServiceException{
        try {
            return dao.getAllRequests();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
