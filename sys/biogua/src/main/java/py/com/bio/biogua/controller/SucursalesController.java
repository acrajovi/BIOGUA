/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import py.com.bio.biogua.model.Sucursales;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.service.SucursalesService;
import py.com.bio.biogua.utilities.Constans;
import py.com.bio.biogua.utilities.ManejadorMensajes;

/**
 *
 * @author jacosta
 */
@Controller
@RequestMapping("/sucursales")
public class SucursalesController extends GenericController {

    @Autowired
    SucursalesService sucursalesService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/lista"}, method = RequestMethod.GET)
    public String listar(ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        cargarDatos(model, request);
        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
            enviarLogIn();
            return enviarLogIn();
        }

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
        List<Sucursales> sucursales = new ArrayList<Sucursales>();

        try {
            sucursales = sucursalesService.obtenerSucursales(null);

            model.addAttribute("lista", sucursales);
            model.addAttribute("filtros", new Filtros());

            return "sucursalesList";

        } catch (Exception e) {
            return this.enviarMenuPrincipal();
        }

    }

    @RequestMapping(value = {"/buscar"}, method = RequestMethod.POST)
    public String buscar(Filtros filtros, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
            enviarLogIn();
            return enviarLogIn();
        }

        List<Sucursales> sucursales = new ArrayList<Sucursales>();

        try {
            cargarDatos(model, request);
            sucursales = sucursalesService.obtenerSucursales(filtros);

            model.addAttribute("lista", sucursales);
            model.addAttribute("filtros", filtros!=null?filtros: new Filtros());

            return "sucursalesList";

        } catch (Exception e) {

            return this.enviarMenuPrincipal();

        }
    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
            enviarLogIn();
            return enviarLogIn();
        }

        Sucursales sucursal = new Sucursales();

        cargarDatos(model, request);

//        model.addAttribute("usuariosys", this.getUsuario());
        model.addAttribute("sucursales", sucursal);

        return "sucursalesForm";

    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(@Valid Sucursales sucursal, BindingResult result, ModelMap model,
            RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
            enviarLogIn();
            return enviarLogIn();
        }

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);

        cargarDatos(model, request);
//MensajesMetodos mensajes = new MensajesMetodos();

        /*
		 * Si no tiene autorizacion reenvia a la pantalla principal
         */
//		if (!this.comprobarAutorizacionAccesoMenus(AppController.getPrincipal(), ConstantesRoles.ROL_GESTIONAR_ESTADOS))
//			return this.enviarMenuPrincipal(mensajes, objectosRedirigidos, messageSource, "form.noAutorizado");
//
//		MensajesMetodos.obtenerMensajesRedirigidos(mensajes, model);
//
//		this.registrarMenus(model);
        sucursal.setUsuarioSys(getUsuario());
        model.addAttribute("filtros", new Filtros());
//		if (!Utilitarios.validarSoloLetras(estado.getDescripcion(), mensajes, model, messageSource)) {
//
//			return nuevo(model, objectosRedirigidos);
//
//		}
        try {

            if (sucursal.getId() == null) {

                sucursalesService.guardar(sucursal);
                ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.guardado");

            } else {

                sucursalesService.actualizar(sucursal);
                ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.actualizado");
            }

        } catch (Exception e) {

//			try {
//
//				new DbExceptions(e);
//
//			} catch (Throwable tx) {
//
//				model.addAttribute("estadoes", estado);
//				MensajesMetodos.enviarMensajeError(mensajes, model, messageSource, getFormulario(), tx.getMessage());
//
//			}
//
//			return nuevo(model, objectosRedirigidos);
        }

        return listar(model, objectosRedirigidos, request);

    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
            enviarLogIn();
            return enviarLogIn();
        }
        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
        try {
            cargarDatos(model, request);
            /**
             * REGISTRA EN LA AUDITORIA EL USUARIO QUE ELIMINO EL REGISTRO *
             */
            Sucursales sucursal = sucursalesService.obtenerById(id);

            sucursalesService.actualizar(sucursal);
            sucursalesService.eliminarById(id);

            ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.eliminado");

        } catch (Exception e) {

//			try {
//
////				new DbExceptions(Utilitarios.validarEliminacion(e));
//
//			} catch (Throwable tx) {
//
//				MensajesMetodos.enviarMensajeError(mensajes, model, messageSource, getFormulario(), tx.getMessage());
//
//			}
        }

        return listar(model, objectosRedirigidos, request);
    }

    @RequestMapping(value = "/editar/{id}")
    public String editar(@PathVariable Integer id, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
            enviarLogIn();
            return enviarLogIn();
        }

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
        try {
            cargarDatos(model, request);

            model.addAttribute("sucursales", sucursalesService.obtenerById(id));
            ManejadorMensajes.enviarMensajeWarning(mensajes, model, messageSource, "mensajes.editando");

        } catch (Exception e) {
//
//			try {
//
//				new DbExceptions(e);
//
//			} catch (Throwable tx) {
//
//				MensajesMetodos.enviarMensajeError(mensajes, model, messageSource, getFormulario(), tx.getMessage());
//
//			}

        }

        return "sucursalesForm";

    }
}
