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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author jacosta
 */
@Entity
@Table(name = "roles_pantallas")
public class RolesPantallas implements Serializable {

    private static final long serialVersionUID = -4457705382562385095L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol_pantalla")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_rol")
    private Roles roles;

    @OneToOne
    @JoinColumn(name = "id_pantalla")
    private Pantallas pantallas;

    @Column(name = "usuariosys")
    private String usuariosys;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Pantallas getPantallas() {
        return pantallas;
    }

    public void setPantallas(Pantallas pantallas) {
        this.pantallas = pantallas;
    }

    public String getUsuariosys() {
        return usuariosys;
    }

    public void setUsuariosys(String usuariosys) {
        this.usuariosys = usuariosys;
    }

}