/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.service;

import java.util.List;
import py.com.bio.biogua.model.Estados;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
public interface EstadosService {
  
	public Estados obtenerById(Integer id);

	public void guardar(Estados estado);

	public void actualizar(Estados estado);

	public void eliminarById(Integer id);

	public List<Estados> obtenerEstados(Filtros filtro);
}
