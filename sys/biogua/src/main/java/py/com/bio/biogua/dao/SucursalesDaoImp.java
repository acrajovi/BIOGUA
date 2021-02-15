/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import py.com.bio.biogua.model.Sucursales;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
@Repository("sucursalesDao")
public class SucursalesDaoImp extends AbstractDao<Integer, Sucursales> implements SucursalesDao {

    @Override
    public Sucursales obtenerById(Integer id) {
        Sucursales sucursal = getByKey(id);
        return sucursal;
    }

    @Override
    public void guardar(Sucursales sucursales) {
        persist(sucursales);
    }

    @Override
    public void actualizar(Sucursales sucursales) {
        update(sucursales);
    }

    @Override
    public void eliminarById(Integer id) {
        delete(obtenerById(id));
    }

    @Override
    public List<Sucursales> obtenerSucursales(Filtros filtro) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("descripcion"));
        if (filtro != null) {
            if (filtro.getCriterio() != null) {
                criteria.add(Restrictions.ilike("descripcion", filtro.getFiltro(), filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT));
            }
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Sucursales> sucursales = criteria.list();
        return sucursales;
    }
}
