/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jacosta
 */
@Entity
@Table(name = "sucursales")
public class Sucursales implements Serializable {

    private static final long serialVersionUID = -4457705382562385095L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "usuariosys")
    private String usuarioSys;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUsuarioSys() {
        return usuarioSys;
    }

    public void setUsuarioSys(String usuarioSys) {
        this.usuarioSys = usuarioSys;
    }
}
