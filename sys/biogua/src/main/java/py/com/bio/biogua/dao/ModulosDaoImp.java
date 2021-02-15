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
import py.com.bio.biogua.model.Modulos;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
@Repository("modulosDao")
public class ModulosDaoImp extends AbstractDao<Integer, Modulos> implements ModulosDao {

    @Override
    public Modulos obtenerById(Integer id) {
        Modulos modulo = getByKey(id);
        return modulo;
    }

    @Override
    public void guardar(Modulos modulo) {
        persist(modulo);
    }

    @Override
    public void actualizar(Modulos modulos) {
        update(modulos);
    }

    @Override
    public void eliminarById(Integer id) {
        delete(obtenerById(id));
    }

    @Override
    public List<Modulos> obtenerModulos(Filtros filtro) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("descripcion"));
        if (filtro != null) {
            if (filtro.getCriterio() != null) {
                criteria.add(Restrictions.ilike("descripcion", filtro.getFiltro(),
                        filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT));
            }
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Modulos> modulos = criteria.list();
        return modulos;
    }
}
