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
import py.com.bio.biogua.model.ModulosPantallas;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Pantallas;

/**
 *
 * @author jacosta
 */
@Repository("modulosPantallasDao")
public class ModulosPantallasDaoImp extends AbstractDao<Integer, ModulosPantallas> implements ModulosPantallasDao {

    @Override
    public ModulosPantallas obtenerById(Integer id) {
        ModulosPantallas moduloPantalla = getByKey(id);
        return moduloPantalla;
    }

    @Override
    public void guardar(ModulosPantallas moduloPantalla) {
        persist(moduloPantalla);
    }

    @Override
    public void actualizar(ModulosPantallas moduloPantalla) {
        update(moduloPantalla);
    }

    @Override
    public void eliminarById(Integer id) {
        delete(obtenerById(id));
    }

    @Override
    public List<ModulosPantallas> obtenerModulosPantallas(Filtros filtro) {
        List<ModulosPantallas> modulosPantallas = new ArrayList<ModulosPantallas>();

        Query sql = null;

        if (filtro != null) {

            sql = getSession().createSQLQuery("SELECT * "
                    + "	FROM modulos_pantallas mp "
                    + " JOIN modulos m ON (mp.id_modulo=m.id_modulo) "
                    + " JOIN pantallas p ON(mp.id_pantalla=p.id_pantalla)"
                    + " WHERE m.descripcion ilike '%" + filtro.getFiltro() + "%' "
                    + " OR p.descripcion ilike '%" + filtro.getFiltro() + "%' ");

            modulosPantallas = sql.list();
        }
        return modulosPantallas;
    }

    @Override
    public List<Pantallas> obtenerPantallasDelModuloByIdModulo(Integer id) {
        Query sql = null;
        List<Pantallas> pantallas = new ArrayList<Pantallas>();
        sql = getSession()
                .createQuery("select distinct mp.pantallas " + " from " + " ModulosPantallas as mp, " + " Modulos as m "
                        + " where mp.modulos.id = m.id "
                        + " and mp.modulos.id = " + id + " order by mp.pantallas.descripcion ");
        pantallas = sql.list();
        return pantallas;
    }

    @Override
    public List<Pantallas> obtenerPantallasDelModuloByIdModuloAndDescripcion(Integer id, String descripcion) {
        Query sql = null;
        List<Pantallas> pantallas = new ArrayList<Pantallas>();
        sql = getSession()
                .createQuery("select distinct mp.pantallas " + " from " + " ModulosPantallas as mp, " + " Modulos as m, " + " Pantallas as p "
                        + " where mp.modulos.id = m.id AND mp.pantallas.id = p.id "
                        + " and mp.modulos.id = " + id + " AND (lower(mp.pantallas.descripcion)) like lower('%" + descripcion.replace(" ", "%") + "%') order by mp.pantallas.descripcion ");
        pantallas = sql.list();
        return pantallas;
    }

}
