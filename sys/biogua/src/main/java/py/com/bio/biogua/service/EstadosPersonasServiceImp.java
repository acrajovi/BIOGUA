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
import py.com.bio.biogua.dao.EstadosPersonasDao;
import py.com.bio.biogua.model.EstadosPersonas;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
@Service("estadosPersonasService")
@Transactional
public class EstadosPersonasServiceImp implements EstadosPersonasService {

    @Autowired
    private EstadosPersonasDao dao;

    @Override
    public EstadosPersonas obtenerById(Integer id) {
        return dao.obtenerById(id);
    }

    @Override
    public void guardar(EstadosPersonas estadoPersona) {
        dao.guardar(estadoPersona);
    }

    @Override
    public void actualizar(EstadosPersonas estadoPersona) {
        dao.actualizar(estadoPersona);
    }

    @Override
    public void eliminarById(Integer id) {
        dao.eliminarById(id);
    }

    @Override
    public List<EstadosPersonas> obtenerEstadosPersonas(Filtros filtro) {
        return dao.obtenerEstadosPersonas(filtro);
    }
}
