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
import py.com.bio.biogua.model.Pantallas;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
@Repository("pantallasDao")
public class PantallasDaoImp extends AbstractDao<Integer, Pantallas> implements PantallasDao {

    @Override
    public Pantallas obtenerById(Integer id) {
        Pantallas pantalla = getByKey(id);
        return pantalla;
    }

    @Override
    public void guardar(Pantallas pantalla) {
        persist(pantalla);
    }

    @Override
    public void actualizar(Pantallas pantalla) {
        update(pantalla);
    }

    @Override
    public void eliminarById(Integer id) {
        delete(obtenerById(id));
    }

    @Override
    public List<Pantallas> obtenerPantallas(Filtros filtro) {

        Criteria criteria = createEntityCriteria().addOrder(Order.asc("descripcion"));
        if (filtro != null) {
            if (filtro.getCriterio() != null) {
                criteria.add(Restrictions.ilike("descripcion", filtro.getFiltro(),
                        filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT));
            }
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Pantallas> pantallas = criteria.list();
        return pantallas;
    }
}
