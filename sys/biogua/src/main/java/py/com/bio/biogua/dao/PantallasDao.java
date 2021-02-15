/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.dao;

import java.util.List;
import py.com.bio.biogua.model.Pantallas;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
public interface PantallasDao {

    public Pantallas obtenerById(Integer id);

    public void guardar(Pantallas pantalla);

    public void actualizar(Pantallas pantalla);

    public void eliminarById(Integer id);

    public List<Pantallas> obtenerPantallas(Filtros filtro);
}
