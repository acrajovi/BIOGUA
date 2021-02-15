/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BIOST
 */
@Entity
@Table(name = "parametros_generales")
public class ParametrosGenerales implements Serializable {

    private static final long serialVersionUID = -4457705382562385095L;
    
    @Id
    @Column(name = "parametro")
    private String parametro;

    @Column(name = "valor")
    private String valor;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "usuariosys")
    private String usuarioSys;

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getUsuarioSys() {
        return usuarioSys;
    }

    public void setUsuarioSys(String usuarioSys) {
        this.usuarioSys = usuarioSys;
    }

}
