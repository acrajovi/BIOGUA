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
import py.com.bio.biogua.dao.ParametrosGeneralesDao;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.ParametrosGenerales;

/**
 *
 * @author BIOST
 */
@Service("parametrosGeneralesService")
@Transactional
public class ParametrosGeneralesServiceImpl implements ParametrosGeneralesService{

    @Autowired
    private ParametrosGeneralesDao dao;
    
    @Override
    public ParametrosGenerales obtenerById(String parametro) {
        return dao.obtenerById(parametro);
    }

    @Override
    public void guardar(ParametrosGenerales parametroGeneral) {
        dao.guardar(parametroGeneral);
    }

    @Override
    public void actualizar(ParametrosGenerales parametroGeneral) {
       dao.actualizar(parametroGeneral);
    }

    @Override
    public void eliminarById(String parametro) {
       dao.eliminarById(parametro);
    }

    @Override
    public List<ParametrosGenerales> obtenerParametros(Filtros filtro) {
       return dao.obtenerParametros(filtro);
    }

    
 
    
}
