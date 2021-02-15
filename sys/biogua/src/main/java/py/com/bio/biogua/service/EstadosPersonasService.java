/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.service;

import java.util.List;
import py.com.bio.biogua.model.EstadosPersonas;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
public interface EstadosPersonasService {
  
	public EstadosPersonas obtenerById(Integer id);

	public void guardar(EstadosPersonas estadoPersona);

	public void actualizar(EstadosPersonas estadoPersona);

	public void eliminarById(Integer id);

	public List<EstadosPersonas> obtenerEstadosPersonas(Filtros filtro);
}
