package com.voronovich.service.impl;

import com.voronovich.dao.FriendshipDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Friendship;
import com.voronovich.service.FriendshipService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class FriendshipServiceImpl implements FriendshipService {

    private static Logger log = Logger.getLogger(FriendshipServiceImpl.class);

    @Autowired
    private FriendshipDao dao;

    @Override
    public void saveOrUpdate(Friendship friendship){
        try {
            dao.saveOrUpdate(friendship);
        } catch (DaoException e) {
            log.error("Error in saveOrUpdate(Friendship friendship) ",e);
        }
    }

    @Override
    public void delete(Friendship friendship){
        try {
            dao.delete(friendship);
        } catch (DaoException e) {
            log.error("Error in delete(Friendship friendship) ",e);
        }
    }

    @Override
    public Friendship get(Serializable id){
        try {
            return dao.get(id);
        } catch (DaoException e) {
            log.error("Error in Friendship get(Serializable id) ",e);
        }
        return null;
    }

    @Override
    public List<Friendship> getAllFriendships(){
        try {
            return dao.getAllFriendships();
        } catch (DaoException e) {
            log.error("Error in List<Friendship> getAllFriendships() ",e);
        }
        return null;
    }
}
