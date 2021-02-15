/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.service;

import java.util.List;
import py.com.bio.biogua.model.Roles;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
public interface RolesService {
  
	public Roles obtenerById(Integer id);

	public void guardar(Roles rol);

	public void actualizar(Roles rol);

	public void eliminarById(Integer id);

	public List<Roles> obtenerRoles(Filtros filtro);
}
