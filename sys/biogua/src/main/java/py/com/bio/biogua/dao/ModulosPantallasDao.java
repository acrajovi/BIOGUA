/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.dao;

import java.util.List;
import py.com.bio.biogua.model.ModulosPantallas;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Pantallas;

/**
 *
 * @author jacosta
 */
public interface ModulosPantallasDao {

    public ModulosPantallas obtenerById(Integer id);

    public void guardar(ModulosPantallas moduloPantalla);

    public void actualizar(ModulosPantallas moduloPantalla);

    public void eliminarById(Integer id);

    public List<ModulosPantallas> obtenerModulosPantallas(Filtros filtro);

    public List<Pantallas> obtenerPantallasDelModuloByIdModulo(Integer id);

    public List<Pantallas> obtenerPantallasDelModuloByIdModuloAndDescripcion(Integer id, String descripcion);
}
