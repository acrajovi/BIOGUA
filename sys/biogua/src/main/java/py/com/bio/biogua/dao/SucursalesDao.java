/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.dao;

import java.util.List;
import py.com.bio.biogua.model.Sucursales;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
public interface SucursalesDao {

    public Sucursales obtenerById(Integer id);

    public void guardar(Sucursales sucursales);

    public void actualizar(Sucursales sucursales);

    public void eliminarById(Integer id);

    public List<Sucursales> obtenerSucursales(Filtros filtro);
}
