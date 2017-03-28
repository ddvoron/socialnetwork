package com.voronovich.service.impl;

import com.voronovich.dao.RequestDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Request;
import com.voronovich.service.RequestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    private static Logger log = Logger.getLogger(RequestServiceImpl.class);

    @Autowired
    private RequestDao dao;

    @Override
    public void saveOrUpdate(Request request){
        try {
            dao.saveOrUpdate(request);
        } catch (DaoException e) {
            log.error("Error in saveOrUpdate(Request request) ",e);
        }
    }

    @Override
    public void delete(Request request){
        try {
            dao.delete(request);
        } catch (DaoException e) {
            log.error("Error in delete(Request request) ",e);
        }
    }

    @Override
    public Request get(Serializable id){
        try {
            return dao.get(id);
        } catch (DaoException e) {
            log.error("Error in Request get(Serializable id) ",e);
        }
        return null;
    }

    @Override
    public List<Request> getAllRequests(){
        try {
            return dao.getAllRequests();
        } catch (DaoException e) {
            log.error("Error in List<Request> getAllRequests() ",e);
        }
        return null;
    }
}
