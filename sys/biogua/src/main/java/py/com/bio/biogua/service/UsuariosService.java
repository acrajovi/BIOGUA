/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.service;

import java.util.List;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Usuarios;

/**
 *
 * @author BIOST
 */
public interface UsuariosService {

    public Usuarios obtenerById(String usuarios);

    public void guardar(Usuarios usuario);

    public void actualizar(Usuarios usuario);

    public void eliminarById(String usuario);

    public List<Usuarios> obtenerUsuarios(Filtros filtro);
}
