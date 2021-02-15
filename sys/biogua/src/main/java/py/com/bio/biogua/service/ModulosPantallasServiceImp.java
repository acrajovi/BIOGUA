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
import py.com.bio.biogua.dao.ModulosPantallasDao;
import py.com.bio.biogua.dao.PantallasDao;
import py.com.bio.biogua.model.ModulosPantallas;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Pantallas;

/**
 *
 * @author jacosta
 */
@Service("modulosPantallasService")
@Transactional
public class ModulosPantallasServiceImp implements ModulosPantallasService {

    @Autowired
    private ModulosPantallasDao dao;

    @Override
    public ModulosPantallas obtenerById(Integer id) {
        return dao.obtenerById(id);
    }

    @Override
    public void guardar(ModulosPantallas moduloPantalla) {
        dao.guardar(moduloPantalla);
    }

    @Override
    public void actualizar(ModulosPantallas moduloPantalla) {
        dao.actualizar(moduloPantalla);
    }

    @Override
    public void eliminarById(Integer id) {
        dao.eliminarById(id);
    }

    @Override
    public List<ModulosPantallas> obtenerModulosPantallas(Filtros filtro) {
        return dao.obtenerModulosPantallas(filtro);
    }

    @Override
    public List<Pantallas> obtenerPantallasDelModuloByIdModulo(Integer id) {
        return dao.obtenerPantallasDelModuloByIdModulo(id);
    }

    @Override
    public List<Pantallas> obtenerPantallasDelModuloByIdModuloAndDescripcion(Integer id, String descripcion) {
        return dao.obtenerPantallasDelModuloByIdModuloAndDescripcion(id, descripcion);
    }

}
