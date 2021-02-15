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
import py.com.bio.biogua.dao.SucursalesDao;
import py.com.bio.biogua.model.Sucursales;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
@Service("sucursalesService")
@Transactional
public class SucursalesServiceImp implements SucursalesService {

    @Autowired
    private SucursalesDao dao;

    @Override
    public Sucursales obtenerById(Integer id) {
        return dao.obtenerById(id);
    }

    @Override
    public void guardar(Sucursales sucursales) {
        dao.guardar(sucursales);
    }

    @Override
    public void actualizar(Sucursales sucursales) {
        dao.actualizar(sucursales);
    }

    @Override
    public void eliminarById(Integer id) {
        dao.eliminarById(id);
    }

    @Override
    public List<Sucursales> obtenerSucursales(Filtros filtro) {
        return dao.obtenerSucursales(filtro);
    }
}
