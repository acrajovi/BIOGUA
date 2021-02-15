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
import py.com.bio.biogua.dao.ModulosDao;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Modulos;

/**
 *
 * @author jacosta
 */
@Service("modulosService")
@Transactional
public class ModulosServiceImp implements ModulosService {

    @Autowired
    private ModulosDao dao;

    @Override
    public Modulos obtenerById(Integer id) {
        return dao.obtenerById(id);
    }

    @Override
    public void guardar(Modulos modulo) {
        dao.guardar(modulo);
    }

    @Override
    public void actualizar(Modulos modulo) {
        dao.actualizar(modulo);
    }

    @Override
    public void eliminarById(Integer id) {
        dao.eliminarById(id);
    }

    @Override
    public List<Modulos> obtenerModulos(Filtros filtro) {
        return dao.obtenerModulos(filtro);
    }
}
