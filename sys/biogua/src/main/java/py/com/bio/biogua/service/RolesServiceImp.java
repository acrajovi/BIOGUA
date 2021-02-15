/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import py.com.bio.biogua.dao.RolesDao;
import py.com.bio.biogua.model.Roles;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
@Service("rolesService")
@Transactional
public class RolesServiceImp implements RolesService {

    @Autowired
    private RolesDao dao;

    @Override
    public Roles obtenerById(Integer id) {
        return dao.obtenerById(id);
    }

    @Override
    public void guardar(Roles rol) {
        dao.guardar(rol);
    }

    @Override
    public void actualizar(Roles rol) {
        dao.actualizar(rol);
    }

    @Override
    public void eliminarById(Integer id) {
        dao.eliminarById(id);
    }

    @Override
    public List<Roles> obtenerRoles(Filtros filtro) {
        return dao.obtenerRoles(filtro);
    }
}
