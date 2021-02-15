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
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.ParametrosGenerales;

/**
 *
 * @author BIOST
 */
@Repository("parametrosGeneralesDao")
public class ParametrosGeneralesDaoImpl extends AbstractDao<String, ParametrosGenerales> implements ParametrosGeneralesDao {

    @Override
    public ParametrosGenerales obtenerById(String parametro) {
        ParametrosGenerales parametroGeneral = getByKey(parametro);
        return parametroGeneral;
    }

    @Override
    public void guardar(ParametrosGenerales parametroGneral) {
        persist(parametroGneral);
    }

    @Override
    public void actualizar(ParametrosGenerales parametroGneral) {
        update(parametroGneral);
    }

    @Override
    public void eliminarById(String parametro) {
        delete(obtenerById(parametro));
    }

    @Override
    public List<ParametrosGenerales> obtenerParametros(Filtros filtro) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("parametro"));
        if (filtro != null) {
            if (filtro.getCriterio() != null) {
                criteria.add(Restrictions.ilike("descripcion", filtro.getFiltro(), filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT));
            }
        }
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<ParametrosGenerales> parametros = criteria.list();
        return parametros;
    }

}
