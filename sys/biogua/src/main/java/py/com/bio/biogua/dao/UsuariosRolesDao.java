/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.dao;

import java.util.List;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Roles;
import py.com.bio.biogua.model.UsuariosRoles;

/**
 *
 * @author jacosta
 */
public interface UsuariosRolesDao {

    public UsuariosRoles obtenerById(Integer id);

    public void guardar(UsuariosRoles usuarioRol);

    public void actualizar(UsuariosRoles usuariosRol);

    public void eliminarById(Integer id);

    public List<UsuariosRoles> obtenerUsuariosRoles(Filtros filtro);

    public List<Roles> obtenerRolesDelUsuarioByIdUsuario(String usuario);

    public List<Roles> obtenerRolesDisponiblesByIdUsuario(String usuario);

}
