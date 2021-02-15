/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import py.com.bio.biogua.model.UsuariosRoles;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Roles;

/**
 *
 * @author jacosta
 */
@Repository("usuariosRolesDao")
public class UsuariosRolesDaoImp extends AbstractDao<Integer, UsuariosRoles> implements UsuariosRolesDao {

    @Override
    public UsuariosRoles obtenerById(Integer id) {
        UsuariosRoles usuarioRol = getByKey(id);
        return usuarioRol;
    }

    @Override
    public void guardar(UsuariosRoles usuarioRol) {
        persist(usuarioRol);
    }

    @Override
    public void actualizar(UsuariosRoles usuarioRol) {
        update(usuarioRol);
    }

    @Override
    public void eliminarById(Integer id) {
        delete(obtenerById(id));
    }

    @Override
    public List<UsuariosRoles> obtenerUsuariosRoles(Filtros filtro) {
        List<UsuariosRoles> UsuariosRoles = new ArrayList<UsuariosRoles>();

        Query sql = null;

        if (filtro != null) {

            sql = getSession().createSQLQuery("SELECT * "
                    + "	FROM modulos_pantallas mp "
                    + " JOIN modulos m ON (mp.id_modulo=m.id_modulo) "
                    + " JOIN pantallas p ON(mp.id_pantalla=p.id_pantalla)"
                    + " WHERE m.descripcion ilike '%" + filtro.getFiltro() + "%' "
                    + " OR p.descripcion ilike '%" + filtro.getFiltro() + "%' ");

            UsuariosRoles = sql.list();
        }
        return UsuariosRoles;
    }

    @Override
    public List<Roles> obtenerRolesDelUsuarioByIdUsuario(String usuario) {
        Query sql = null;
        List<Roles> roles = new ArrayList<Roles>();
        sql = getSession()
                .createQuery("select distinct ur.roles " + " from " + " UsuariosRoles as ur, " + " Usuarios as u, " + " Roles as r, "
                        + " where ur.roles.id = r.id and ur.usuarios.usuario=u.usuario "
                        + " and ur.usuarios.usuario = '" + usuario + "' order by ur.roles.descripcion ");
        roles = sql.list();
        return roles;
    }

    @Override
    public List<Roles> obtenerRolesDisponiblesByIdUsuario(String usuario) {
        Query sql = null;
        List<Roles> pantallas = new ArrayList<Roles>();
        sql = getSession()
                .createQuery("select distinct mp.pantallas " + " from " + " ModulosPantallas as mp, " + " Modulos as m, " + " Pantallas as p "
                        + " where mp.modulos.id = m.id AND mp.pantallas.id = p.id "
                        + " and mp.modulos.id = " + usuario + " AND (lower(mp.pantallas.descripcion)) like lower('%" + usuario.replace(" ", "%") + "%') order by mp.pantallas.descripcion ");
        pantallas = sql.list();
        return pantallas;
    }

}
