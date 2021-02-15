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
import py.com.bio.biogua.model.RolesPantallas;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Pantallas;

/**
 *
 * @author jacosta
 */
@Repository("rolesPantallasDao")
public class RolesPantallasDaoImp extends AbstractDao<Integer, RolesPantallas> implements RolesPantallasDao {

    @Override
    public RolesPantallas obtenerById(Integer id) {
        RolesPantallas rolPantalla = getByKey(id);
        return rolPantalla;
    }

    @Override
    public void guardar(RolesPantallas rolPantalla) {
        persist(rolPantalla);
    }

    @Override
    public void actualizar(RolesPantallas rolPantalla) {
        update(rolPantalla);
    }

    @Override
    public void eliminarById(Integer id) {
        delete(obtenerById(id));
    }

    @Override
    public List<RolesPantallas> obtenerRolesPantallas(Filtros filtro) {
        List<RolesPantallas> rolesPantallas = new ArrayList<RolesPantallas>();

        Query sql = null;

        if (filtro != null) {

            sql = getSession().createSQLQuery("SELECT * "
                    + "	FROM roles_pantallas rp "
                    + " JOIN roles m ON (rp.id_rol=p.id_pantalla) "
                    + " JOIN pantallas p ON(rp.id_pantalla=p.id_pantalla)"
                    + " WHERE r.descripcion ilike '%" + filtro.getFiltro() + "%' "
                    + " OR p.descripcion ilike '%" + filtro.getFiltro() + "%' ");

            rolesPantallas = sql.list();
        }
        return rolesPantallas;
    }

    @Override
    public List<Pantallas> obtenerPantallasDelRolByIdRol(Integer id) {
        Query sql = null;
        List<Pantallas> pantallas = new ArrayList<Pantallas>();
        sql = getSession()
                .createQuery("select distinct rp.pantallas " + " from " + " RolesPantallas as rp, " + " Roles as r "
                        + " where rp.roles.id = r.id "
                        + " and rp.roles.id = " + id + " order by rp.pantallas.descripcion ");
        pantallas = sql.list();
        return pantallas;
    }

    @Override
    public List<Pantallas> obtenerPantallasDelRolByIdRolesAndDescripcion(Integer id, String descripcion) {
        Query sql = null;
        List<Pantallas> pantallas = new ArrayList<Pantallas>();
        sql = getSession()
                .createQuery("select distinct rp.pantallas " + " from " + " RolesPantallas as rp, " + " Roles as r, " + " Pantallas as p "
                        + " where rp.roles.id = r.id AND rp.pantallas.id = p.id "
                        + " and rp.roles.id = " + id + " AND (lower(rp.pantallas.descripcion)) like lower('%" + descripcion.replace(" ", "%") + "%') order by rp.pantallas.descripcion ");
        pantallas = sql.list();
        return pantallas;
    }

}
