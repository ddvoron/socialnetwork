package com.voronovich.service;

import com.voronovich.pojo.Role;
import com.voronovich.exceptions.ServiceException;

import java.io.Serializable;
import java.util.List;

public interface RoleService {

    /**
     * Saves or updates role
     *
     * @param role Role
     */
    void saveOrUpdate(Role role) throws ServiceException;

    /**
     * Removes role
     *
     * @param role Role
     */
    void delete(Role role) throws ServiceException;

    /**
     * Reads role
     *
     * @param id - role id
     * @return Role
     */
    Role get(Serializable id) throws ServiceException;

    /**
     * Reads the whole list of roles
     *
     * @return List<Role>
     */
    List<Role> getAllRoles() throws ServiceException;
}
