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
import py.com.bio.biogua.model.Usuarios;

/**
 *
 * @author BIOST
 */
@Repository("UsuariosDao")
public class UsuariosDaoImpl extends AbstractDao<String, Usuarios> implements UsuariosDao {

    @Override
    public Usuarios obtenerById(String usuario) {
        Usuarios usuarios = getByKey(usuario);
        return usuarios;
    }

    @Override
    public void guardar(Usuarios usuario) {
        persist(usuario);
    }

    @Override
    public void actualizar(Usuarios usuario) {
        update(usuario);
    }

    @Override
    public void eliminarById(String usuario) {
        delete(obtenerById(usuario));
    }

    @Override
    public List<Usuarios> obtenerUsuarios(Filtros filtro) {

        Criteria criteria = createEntityCriteria().addOrder(Order.asc("usuario"))
                .addOrder(Order.asc("nombre"))
                .addOrder(Order.asc("apellido"));
        
        criteria.createAlias("estadosPersonas", "estadosPersonas");
        criteria.createAlias("sucursales", "sucursales");

        if (filtro != null) {
            if (filtro.getCriterio() != null) {

                String[] palabras = filtro.getFiltro().split(" ");

                for (String palabra : palabras) {
                    if (palabra.contains(" ")) {
                        continue;
                    }
                    if ("--".equals(filtro.getCriterio())) {
                        criteria.add(Restrictions.disjunction()
                                .add(Restrictions.or(Restrictions.ilike("ci", palabra,
                                        filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT)))
                                .add(Restrictions.or(Restrictions.ilike("usuario", palabra,
                                        filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT)))
                                .add(Restrictions.or(Restrictions.ilike("nombre", palabra,
                                        filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT)))
                                .add(Restrictions.or(Restrictions.ilike("apellido", palabra,
                                        filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT)))
                                .add(Restrictions.or(Restrictions.ilike("estadosPersonas.descripcion", palabra,
                                        filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT)))
                                .add(Restrictions.or(Restrictions.ilike("sucursales.descripcion", palabra,
                                        filtro.getAproximacion() ? MatchMode.ANYWHERE : MatchMode.EXACT)))
                        );
                    }
                }
            }
        }

        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        List<Usuarios> usuarios = criteria.list();
        return usuarios;
    }
}
