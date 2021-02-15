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
import py.com.bio.biogua.model.EstadosPersonas;
import py.com.bio.biogua.model.Filtros;

/**
 *
 * @author jacosta
 */
@Repository("estadosPersonasDao")
public class EstadosPersonasDaoImp extends AbstractDao<Integer, EstadosPersonas> implements EstadosPersonasDao {

    @Override
    public EstadosPersonas obtenerById(Integer id) {
        EstadosPersonas estadoPersona = getByKey(id);
        return estadoPersona;
    }

    @Override
    public void guardar(EstadosPersonas estadoPersona) {
        persist(estadoPersona);
    }

    @Override
    public void actualizar(EstadosPersonas estadoPersona) {
        update(estadoPersona);
    }

    @Override
    public void eliminarById(Integer id) {
        delete(obtenerById(id));
    }

    @Override
    public List<EstadosPersonas> obtenerEstadosPersonas(Filtros filtro) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("descripcion"));
        if (filtro != null) {
            if (filtro.getCriterio() != null) {
                criteria.add(Restrictions.ilike("descripcion", filtro.getFiltro(), filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT));
            }
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<EstadosPersonas> estadosPersonas = criteria.list();
        return estadosPersonas;
    }

}
