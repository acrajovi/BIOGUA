/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.service;

import java.util.List;
import py.com.bio.biogua.model.Modulos;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
public interface ModulosService {

    public Modulos obtenerById(Integer id);

    public void guardar(Modulos modulo);

    public void actualizar(Modulos modulo);

    public void eliminarById(Integer id);

    public List<Modulos> obtenerModulos(Filtros filtro);
}
