package com.voronovich.service.impl;

import com.voronovich.dao.FriendshipDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.exceptions.ServiceException;
import com.voronovich.pojo.Friendship;
import com.voronovich.service.FriendshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class FriendshipServiceImpl implements FriendshipService {

    @Autowired
    private FriendshipDao dao;

    @Override
    public void saveOrUpdate(Friendship friendship) throws ServiceException{
        try {
            dao.saveOrUpdate(friendship);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Friendship friendship) throws ServiceException{
        try {
            dao.delete(friendship);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Friendship get(Serializable id) throws ServiceException{
        try {
            return dao.get(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Friendship> getAllFriendships() throws ServiceException{
        try {
            return dao.getAllFriendships();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
