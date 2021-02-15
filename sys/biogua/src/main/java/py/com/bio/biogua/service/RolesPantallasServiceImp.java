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
import py.com.bio.biogua.dao.RolesPantallasDao;
import py.com.bio.biogua.dao.PantallasDao;
import py.com.bio.biogua.model.RolesPantallas;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Pantallas;

/**
 *
 * @author jacosta
 */
@Service("rolesPantallasService")
@Transactional
public class RolesPantallasServiceImp implements RolesPantallasService {

    @Autowired
    private RolesPantallasDao dao;

    @Override
    public RolesPantallas obtenerById(Integer id) {
        return dao.obtenerById(id);
    }

    @Override
    public void guardar(RolesPantallas rolPantalla) {
        dao.guardar(rolPantalla);
    }

    @Override
    public void actualizar(RolesPantallas rolPantalla) {
        dao.actualizar(rolPantalla);
    }

    @Override
    public void eliminarById(Integer id) {
        dao.eliminarById(id);
    }

    @Override
    public List<RolesPantallas> obtenerRolesPantallas(Filtros filtro) {
        return dao.obtenerRolesPantallas(filtro);
    }

    @Override
    public List<Pantallas> obtenerPantallasDelRolByIdRol(Integer id) {
        return dao.obtenerPantallasDelRolByIdRol(id);
    }

    @Override
    public List<Pantallas> obtenerPantallasDelRolByIdRolAndDescripcion(Integer id, String descripcion) {
        return dao.obtenerPantallasDelRolByIdRolesAndDescripcion(id, descripcion);
    }

}
