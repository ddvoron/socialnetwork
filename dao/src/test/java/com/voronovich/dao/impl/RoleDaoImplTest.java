package com.voronovich.dao.impl;

import com.voronovich.dao.RoleDao;
import com.voronovich.exceptions.DaoException;
import com.voronovich.pojo.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ContextConfiguration("/beans-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback
public class RoleDaoImplTest {

    @Autowired
    private RoleDao dao;

    @Test
    public void saveRole() throws DaoException {
        Role role = new Role(0, "test");
        List<Role> before = dao.getAllRoles();
        int sizeBefore = before.size();
        dao.saveOrUpdate(role);
        List<Role> after = dao.getAllRoles();
        int sizeAfter = after.size();
        Assert.assertEquals("Not created", sizeBefore + 1, sizeAfter);
    }

    @Test
    public void getRoleById() throws DaoException {
        Role role = dao.get(2);
        Assert.assertEquals("Not got", "administrator", role.getRole());
    }

    @Test
    public void deleteRole() throws DaoException {
        List<Role> before = dao.getAllRoles();
        int sizeBefore = before.size();
        Role role = dao.get(10);
        dao.delete(role);
        List<Role> after = dao.getAllRoles();
        int sizeAfter = after.size();
        Assert.assertEquals("Not deleted", sizeBefore - 1, sizeAfter);
    }
}
