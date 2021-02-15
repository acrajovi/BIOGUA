package py.com.bio.biogua.model;

import java.util.List;

public class Filtros {

	private String criterio;
	private boolean aproximacion = false;
	private String filtro;
	private short cantidadRegistros;
	private List<Filtros> filtros;
	private Object criterioClase;

	/**
	 * Metodo que obtiene la información que se desea buscar
	 * 
	 * @return El valor que se desea buscar.
	 */
	public String getFiltro() {
		return filtro;
	}

	/**
	 * Metodo que especifica la información que se desea buscar
	 * 
	 * @param filtro
	 */
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	/**
	 * Metodo que obtiene el campo donde se desea buscar.
	 * 
	 * @return El campo que se desea buscar.
	 */
	public String getCriterio() {
		return criterio;
	}

	/**
	 * Metodo que especifica el campo en el que se desea buscar
	 * 
	 * @param criterio
	 */

	public void setCriterio(String criterio) {
		this.criterio = criterio;
		if (criterio != null && !"".equals(criterio)) {
			setAproximacion(true);

		} else {
			setAproximacion(false);
		}
	}

	/**
	 * Metodo que obtiene si la busqueda sera por aproximación
	 * 
	 * @return El valor si la busqueda sera por aproximación.
	 */
	public boolean getAproximacion() {
		return aproximacion;
	}

	/**
	 * Metodo que especifica que la busqueda sea por aproximación {@code true}
	 * por aproximación {@code false} exacto
	 * 
	 * @param aproximacion
	 */
	public void setAproximacion(boolean aproximacion) {
		this.aproximacion = aproximacion;
	}

	/**
	 * metodo que obtiene si la busqueda tendra varios criterios
	 * 
	 * @return
	 */

	public List<Filtros> getFiltros() {
		return filtros;
	}

	public void setFiltros(List<Filtros> filtros) {
		this.filtros = filtros;
	}

	public short getCantidadRegistros() {
		return cantidadRegistros;
	}

	public void setCantidadRegistros(short cantidadRegistros) {
		this.cantidadRegistros = cantidadRegistros;
	}

	public Object getCriterioClase() {
		return criterioClase;
	}

	public void setCriterioClase(Object criterioClase) {
		this.criterioClase = criterioClase;
	}

}
