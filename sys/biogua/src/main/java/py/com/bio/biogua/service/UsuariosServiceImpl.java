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
import py.com.bio.biogua.dao.UsuariosDao;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Usuarios;

/**
 *
 * @author BIOST
 */
@Service("usuariosService")
@Transactional
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    UsuariosDao dao;

    @Override
    public Usuarios obtenerById(String usuarios) {
        return dao.obtenerById(usuarios);
    }

    @Override
    public void guardar(Usuarios usuario) {
        dao.guardar(usuario);
    }

    @Override
    public void actualizar(Usuarios usuario) {
        dao.actualizar(usuario);
    }

    @Override
    public void eliminarById(String usuario) {
        dao.eliminarById(usuario);
    }

    @Override
    public List<Usuarios> obtenerUsuarios(Filtros filtro) {
        return dao.obtenerUsuarios(filtro);
    }

}
