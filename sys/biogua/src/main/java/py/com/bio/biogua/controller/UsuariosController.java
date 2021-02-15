/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.ParametrosGenerales;
import py.com.bio.biogua.model.Roles;
import py.com.bio.biogua.model.Usuarios;
import py.com.bio.biogua.service.EstadosPersonasService;
import py.com.bio.biogua.service.ParametrosGeneralesService;
import py.com.bio.biogua.service.SucursalesService;
import py.com.bio.biogua.service.UsuariosService;
import py.com.bio.biogua.utilities.Constans;
import py.com.bio.biogua.utilities.ManejadorMensajes;

/**
 *
 * @author BIOST
 */
@Controller
@RequestMapping("/usuarios")
@SessionAttributes("roles")
public class UsuariosController extends GenericController {

    @Autowired
    EstadosPersonasService estadosPersonasServices;

    @Autowired
    SucursalesService sucursalesServices;

    @Autowired
    ParametrosGeneralesService parametrosGeneralesServices;

    @Autowired
    UsuariosService usuariosService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    @RequestMapping(value = {"/", "/lista"}, method = RequestMethod.GET)
    public String listar(ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
        cargarDatos(model, request);

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);

        List<Usuarios> usuarios = new ArrayList<Usuarios>();

        try {
            usuarios = usuariosServices.obtenerUsuarios(null);

            model.addAttribute("lista", usuarios);
            model.addAttribute("filtros", new Filtros());
            return "usuariosList";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return this.enviarMenuPrincipal();
        }
    }

    @RequestMapping(value = {"/buscar"}, method = RequestMethod.POST)
    public String buscar(Filtros filtros, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        List<Usuarios> usuarios = new ArrayList<Usuarios>();

        try {
            cargarDatos(model, request);
            usuarios = usuariosServices.obtenerUsuarios(filtros);

            model.addAttribute("lista", usuarios);
            model.addAttribute("filtros", filtros != null ? filtros : new Filtros());

            return "usuariosList";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return this.enviarMenuPrincipal();
        }
    }

    @RequestMapping(value = {"/nuevo"}, method = RequestMethod.GET)
    public String nuevo(ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        Usuarios usuarios = new Usuarios();

        cargarDatos(model, request);

        model.addAttribute("usuarios", usuarios);
        model.addAttribute("nuevo", true);
        model.addAttribute("sucursales", sucursalesServices.obtenerSucursales(null));
        model.addAttribute("estadosPersonas", estadosPersonasServices.obtenerEstadosPersonas(null));

        return "usuariosForm";
    }

    @RequestMapping(value = {"/guardar"}, method = RequestMethod.POST)
    public String guardar(@Valid Usuarios usuario, BindingResult result, ModelMap model,
            RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);

        cargarDatos(model, request);

        Filtros filtro = new Filtros();

        //buscamos usuarios con ese mismo username para saber si es nuevo registro o actualización
        filtro.setCriterio("usuario");
        filtro.setFiltro(usuario.getUsuario());

        List<Usuarios> lista = usuariosServices.obtenerUsuarios(filtro);

        try {
            if (lista.isEmpty()) {
                //significa que el usuario es nuevo
                //asignamos variables
                usuario.setCi(usuario.getCi().replace(".", ""));
                usuario.setFecha_alta(new Date());
                usuario.setFecha_caduca(new Date());
                usuario.setFecha_cambio_estado(new Date());
                usuario.setEstadosPersonas(estadosPersonasServices.obtenerById(Constans.COD_ESTADO_PERSONA_ACTIVO));
                ParametrosGenerales parametrosGenerales = parametrosGeneralesServices.obtenerById(Constans.PG_GENERIC_PASS);
                String genericPass = parametrosGenerales.getValor();
                usuario.setPass(passwordEncoder.encode(genericPass));

                usuario.setUsuarioSys(this.getUsuario());
                usuariosServices.guardar(usuario);
                ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.guardado");
            } else {
                //obtenemos todos los datos del usuario por userid

                //y seteamos los valores que cambiaremos                
                Usuarios usuarioActualizado = usuariosServices.obtenerById(usuario.getUsuario());
                usuarioActualizado.setNombre(usuario.getNombre());
                usuarioActualizado.setApellido(usuario.getApellido());
                usuarioActualizado.setSucursales(usuario.getSucursales());
                usuarioActualizado.setUsuarioSys(this.getUsuario());

                if (!usuario.getEstadosPersonas().getId().equals(usuarioActualizado.getEstadosPersonas().getId())) {
                    //significa que cambio de estado
                    usuarioActualizado.setFecha_cambio_estado(new Date());
                    usuarioActualizado.setEstadosPersonas(usuario.getEstadosPersonas());
                }

                usuariosServices.actualizar(usuarioActualizado);
                ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.actualizado");
            }
        } catch (Exception e) {
            ManejadorMensajes.enviarMensajeError(mensajes, model, messageSource, e.getMessage(), e.getMessage());
        }
        return listar(model, objectosRedirigidos, request);
    }

    /**
     * This method will delete an user by it's SSOID value.
     *
     * @param usuario
     * @param model
     * @param objectosRedirigidos
     * @param request
     * @return
     */
    @RequestMapping(value = {"/eliminar/{usuario}"}, method = RequestMethod.GET)
    public String eliminar(@PathVariable String usuario, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
        try {
            cargarDatos(model, request);

            Usuarios usuarios = usuariosServices.obtenerById(usuario);

            usuariosServices.actualizar(usuarios);
            usuariosServices.eliminarById(usuario);
            ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.eliminado");
        } catch (Exception e) {

        }
        return listar(model, objectosRedirigidos, request);
    }

    @RequestMapping(value = "/editar/{usuario}")
    public String editar(@PathVariable String usuario, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);

        try {
            cargarDatos(model, request);
            model.addAttribute("usuarios", usuariosServices.obtenerById(usuario));
            model.addAttribute("sucursales", sucursalesServices.obtenerSucursales(null));
            model.addAttribute("estadosPersonas", estadosPersonasServices.obtenerEstadosPersonas(null));
            model.addAttribute("nuevo", false);
            ManejadorMensajes.enviarMensajeWarning(mensajes, model, messageSource, "mensajes.editando");

        } catch (Exception e) {

        }
        return "usuariosForm";
    }

    @RequestMapping(value = "/restablecerPass/{usuario}")
    public String restablecerPass(@PathVariable String usuario, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);

        try {
            cargarDatos(model, request);

            Usuarios usuarioActualizado = usuariosServices.obtenerById(usuario);

            ParametrosGenerales parametrosGenerales = parametrosGeneralesServices.obtenerById(Constans.PG_GENERIC_PASS);
            String genericPass = parametrosGenerales.getValor();

            usuarioActualizado.setPass(passwordEncoder.encode(genericPass));
            usuarioActualizado.setFecha_caduca(new Date());

            usuariosServices.actualizar(usuarioActualizado);
            model.addAttribute("usuarios", usuariosServices.obtenerById(usuario));
            model.addAttribute("sucursales", sucursalesServices.obtenerSucursales(null));
            model.addAttribute("estadosPersonas", estadosPersonasServices.obtenerEstadosPersonas(null));
            model.addAttribute("nuevo", false);
            ManejadorMensajes.enviarMensajeWarning(mensajes, model, messageSource, "mensajes.resetpassOK");

        } catch (Exception e) {

        }
        return "usuariosForm";
    }

    @RequestMapping(value = "/rolesUsuarios/{usuario}")
    public String rolesUusuarios(@PathVariable String usuario, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);

        try {
            cargarDatos(model, request);

            Roles roles = new Roles();

            
            Usuarios usuarioActualizado = usuariosServices.obtenerById(usuario);

            ParametrosGenerales parametrosGenerales = parametrosGeneralesServices.obtenerById(Constans.PG_GENERIC_PASS);
            String genericPass = parametrosGenerales.getValor();

            usuarioActualizado.setPass(passwordEncoder.encode(genericPass));
            usuarioActualizado.setFecha_caduca(new Date());

            usuariosServices.actualizar(usuarioActualizado);
            model.addAttribute("usuarios", usuariosServices.obtenerById(usuario));
            model.addAttribute("sucursales", sucursalesServices.obtenerSucursales(null));
            model.addAttribute("estadosPersonas", estadosPersonasServices.obtenerEstadosPersonas(null));
            model.addAttribute("nuevo", false);
            model.addAttribute("filtros", new Filtros());
            ManejadorMensajes.enviarMensajeWarning(mensajes, model, messageSource, "mensajes.editando");

        } catch (Exception e) {

        }
        return "usuariosRolesList";
    }
}
