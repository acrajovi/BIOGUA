/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.dao;

import java.util.List;
import py.com.bio.biogua.model.Roles;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Pantallas;

/**
 *
 * @author jacosta
 */
public interface RolesDao {

    public Roles obtenerById(Integer id);

    public void guardar(Roles estado);

    public void actualizar(Roles estado);

    public void eliminarById(Integer id);

    public List<Roles> obtenerRoles(Filtros filtro);

    public List<Pantallas> obtenerPantallasDelRolByIdRol(Integer id);

    public List<Pantallas> obtenerPantallasDelRolByIdRolAndDescripcion(Integer id, String descripcion);
}
