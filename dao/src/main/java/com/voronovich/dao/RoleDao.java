package com.voronovich.dao;

import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Role;

import java.util.List;

/**
 * Interface contains additional abstract methods
 * for Role DAO layer
 *
 * @author Dmitry V
 * @version 1.0
 */
public interface RoleDao extends Dao<Role> {

    /**
     * Method reads the whole list of roles
     *
     * @return List<RoleEntity>
     * @throws DaoException
     */
    List<Role> getAllRoles() throws DaoException;
}
