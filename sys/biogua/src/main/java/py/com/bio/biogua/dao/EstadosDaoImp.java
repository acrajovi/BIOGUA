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
import py.com.bio.biogua.model.Estados;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
@Repository("estadosDao")
public class EstadosDaoImp extends AbstractDao<Integer, Estados> implements EstadosDao {

    @Override
    public Estados obtenerById(Integer id) {
        Estados estado = getByKey(id);
        return estado;
    }

    @Override
    public void guardar(Estados estado) {
        persist(estado);
    }

    @Override
    public void actualizar(Estados estado) {
        update(estado);
    }

    @Override
    public void eliminarById(Integer id) {
        delete(obtenerById(id));
    }

    @Override
    public List<Estados> obtenerEstados(Filtros filtro) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("descripcion"));
        if (filtro != null) {
            if (filtro.getCriterio() != null) {
                criteria.add(Restrictions.ilike("descripcion", filtro.getFiltro(),
                        filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT));
            }
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Estados> estados = criteria.list();
        return estados;
    }

}
