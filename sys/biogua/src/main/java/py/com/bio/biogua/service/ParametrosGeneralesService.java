/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.service;

import java.util.List;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.ParametrosGenerales;


/**
 *
 * @author BIOST
 */
public interface ParametrosGeneralesService {

    public ParametrosGenerales obtenerById(String parametro);

    public void guardar(ParametrosGenerales parametroGneral);

    public void actualizar(ParametrosGenerales parametroGneral);

    public void eliminarById(String parametro);

    public List<ParametrosGenerales> obtenerParametros(Filtros filtro);
}
