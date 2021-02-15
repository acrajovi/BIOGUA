/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.service;

import java.util.List;
import py.com.bio.biogua.model.RolesPantallas;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Pantallas;

/**
 *
 * @author jacosta
 */
public interface RolesPantallasService {

    public RolesPantallas obtenerById(Integer id);

    public void guardar(RolesPantallas rolPantalla);

    public void actualizar(RolesPantallas rolPantalla);

    public void eliminarById(Integer id);

    public List<RolesPantallas> obtenerRolesPantallas(Filtros filtro);

    public List<Pantallas> obtenerPantallasDelRolByIdRol(Integer id);

    public List<Pantallas> obtenerPantallasDelRolByIdRolAndDescripcion(Integer id, String descripcion);
}
