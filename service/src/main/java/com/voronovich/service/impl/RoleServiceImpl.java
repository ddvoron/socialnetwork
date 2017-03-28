package com.voronovich.service.impl;

import com.voronovich.dao.RoleDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Role;
import com.voronovich.service.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private static Logger log = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleDao dao;

    @Override
    public void saveOrUpdate(Role role){
        try {
            dao.saveOrUpdate(role);
        } catch (DaoException e) {
            log.error("Error in saveOrUpdate(Role role) ",e);
        }
    }

    @Override
    public void delete(Role role){
        try {
            dao.delete(role);
        } catch (DaoException e) {
            log.error("Error in delete(Role role) ",e);
        }
    }

    @Override
    public Role get(Serializable id){
        try {
            return dao.get(id);
        } catch (DaoException e) {
            log.error("Error in Role get(Serializable id) ",e);
        }
        return null;
    }

    @Override
    public List<Role> getAllRoles(){
        try {
            return dao.getAllRoles();
        } catch (DaoException e) {
            log.error("Error in List<Role> getAllRoles() ",e);
        }
        return null;
    }
}
