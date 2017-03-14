package com.voronovich.service.impl;

import com.voronovich.dao.RoleDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Role;
import com.voronovich.service.RoleService;
import com.voronovich.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao dao;

    @Override
    public void saveOrUpdate(Role role) throws ServiceException{
        try {
            dao.saveOrUpdate(role);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void delete(Role role) throws ServiceException{
        try {
            dao.delete(role);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public Role get(Serializable id) throws ServiceException{
        try {
            return dao.get(id);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<Role> getAllRoles() throws ServiceException{
        try {
            return dao.getAllRoles();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
