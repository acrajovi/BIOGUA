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
import py.com.bio.biogua.dao.PantallasDao;
import py.com.bio.biogua.model.Pantallas;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
@Service("pantallasService")
@Transactional
public class PantallasServiceImp implements PantallasService {

    @Autowired
    private PantallasDao dao;

    @Override
    public Pantallas obtenerById(Integer id) {
        return dao.obtenerById(id);
    }

    @Override
    public void guardar(Pantallas pantalla) {
        dao.guardar(pantalla);
    }

    @Override
    public void actualizar(Pantallas pantalla) {
        dao.actualizar(pantalla);
    }

    @Override
    public void eliminarById(Integer id) {
        dao.eliminarById(id);
    }

    @Override
    public List<Pantallas> obtenerPantallas(Filtros filtro) {
        return dao.obtenerPantallas(filtro);
    }
}
