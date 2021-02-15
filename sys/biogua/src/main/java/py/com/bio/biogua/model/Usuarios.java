/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import py.com.bio.biogua.utilities.Constans;

/**
 *
 * @author jacosta
 */
@Entity
@Table(name = "usuarios")
public class Usuarios implements Serializable {

    private static final long serialVersionUID = -4457705382562385095L;

    @Id
    @Column(name = "usuario")
    private String usuario;

    @Column(name = "ci")
    private String ci;

    @OneToOne
    @JoinColumn(name = "id_estado_pers")
    private EstadosPersonas estadosPersonas;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "pass")
    private String pass;

    @Column(name = "ipacceso")
    private String ipacceso;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = Constans.FORMATO_FECHA_DDMMYYYY_1)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_cambio_estado", nullable = false)
    private Date fecha_cambio_estado;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = Constans.FORMATO_FECHA_DDMMYYYY_1)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_caduca", nullable = false)
    private Date fecha_caduca;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = Constans.FORMATO_FECHA_DDMMYYYY_1)
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_alta", nullable = false)
    private Date fecha_alta;

    @OneToOne
    @JoinColumn(name = "id_sucursal")
    private Sucursales sucursales;

    @Column(name = "login_hash")
    private String login_hash;

    @Column(name = "fail_login")
    private int fail_login;

    @Column(name = "usuariosys")
    private String usuarioSys;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public EstadosPersonas getEstadosPersonas() {
        return estadosPersonas;
    }

    public void setEstadosPersonas(EstadosPersonas estadosPersonas) {
        this.estadosPersonas = estadosPersonas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Date getFecha_cambio_estado() {
        return fecha_cambio_estado;
    }

    public void setFecha_cambio_estado(Date fecha_cambio_estado) {
        this.fecha_cambio_estado = fecha_cambio_estado;
    }

    public Date getFecha_caduca() {
        return fecha_caduca;
    }

    public void setFecha_caduca(Date fecha_caduca) {
        this.fecha_caduca = fecha_caduca;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public Sucursales getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }

    public String getLogin_hash() {
        return login_hash;
    }

    public void setLogin_hash(String login_hash) {
        this.login_hash = login_hash;
    }

    public int getFail_login() {
        return fail_login;
    }

    public void setFail_login(int fail_login) {
        this.fail_login = fail_login;
    }

    public String getUsuarioSys() {
        return usuarioSys;
    }

    public void setUsuarioSys(String usuarioSys) {
        this.usuarioSys = usuarioSys;
    }

    public String getIpacceso() {
        return ipacceso;
    }

    public void setIpacceso(String ipacceso) {
        this.ipacceso = ipacceso;
    }

}
