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
import py.com.bio.biogua.dao.EstadosDao;
import py.com.bio.biogua.model.Estados;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */

@Service("estadosService")
@Transactional
public class EstadosServiceImp implements EstadosService {

    @Autowired
    private EstadosDao dao;

    @Override
    public Estados obtenerById(Integer id) {
        return dao.obtenerById(id);
    }

    @Override
    public void guardar(Estados estado) {
        dao.guardar(estado);
    }

    @Override
    public void actualizar(Estados estado) {
        dao.actualizar(estado);
    }

    @Override
    public void eliminarById(Integer id) {
        dao.eliminarById(id);
    }

    @Override
    public List<Estados> obtenerEstados(Filtros filtro) {
        return dao.obtenerEstados(filtro);
    }
}
