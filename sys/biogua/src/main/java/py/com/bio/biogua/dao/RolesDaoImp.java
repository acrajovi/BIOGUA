/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import py.com.bio.biogua.model.Roles;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Pantallas;

/**
 *
 * @author jacosta
 */
@Repository("rolesDao")
public class RolesDaoImp extends AbstractDao<Integer, Roles> implements RolesDao {

    @Override
    public Roles obtenerById(Integer id) {
        Roles rol = getByKey(id);
        return rol;
    }

    @Override
    public void guardar(Roles rol) {
        persist(rol);
    }

    @Override
    public void actualizar(Roles rol) {
        update(rol);
    }

    @Override
    public void eliminarById(Integer id) {
        delete(obtenerById(id));
    }

    @Override
    public List<Roles> obtenerRoles(Filtros filtro) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("descripcion"));
        if (filtro != null) {
            if (filtro.getCriterio() != null) {
                criteria.add(Restrictions.ilike("descripcion", filtro.getFiltro(),
                        filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT));
            }
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Roles> roles = criteria.list();
        return roles;
    }

    @Override
    public List<Pantallas> obtenerPantallasDelRolByIdRol(Integer id) {
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
    public List<Pantallas> obtenerPantallasDelRolByIdRolAndDescripcion(Integer id, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
