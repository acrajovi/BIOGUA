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
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.ParametrosGenerales;
import py.com.bio.biogua.service.ParametrosGeneralesService;
import py.com.bio.biogua.utilities.Constans;
import py.com.bio.biogua.utilities.ManejadorMensajes;

/**
 *
 * @author BIOST
 */
@Controller
@RequestMapping("/parametrosGenerales")
public class ParametrosGeneralesController extends GenericController {

    @Autowired
    ParametrosGeneralesService parametroGeneralService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "lista"}, method = RequestMethod.GET)
    public String listar(ModelMap model, RedirectAttributes objetosRedirigidos, HttpServletRequest request) {

        cargarDatos(model, request);
        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
            enviarLogIn();
            return enviarLogIn();
        }
        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);

        List<ParametrosGenerales> parametrosGenerales = new ArrayList<ParametrosGenerales>();

        try {
            parametrosGenerales = parametroGeneralService.obtenerParametros(null);

            model.addAttribute("lista", parametrosGenerales);
            model.addAttribute("filtros", new Filtros());
            return "parametrosGeneralesList";
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

        List<ParametrosGenerales> parametrosGenerales = new ArrayList<ParametrosGenerales>();

        try {
            cargarDatos(model, request);
            parametrosGenerales = parametroGeneralService.obtenerParametros(filtros);

            model.addAttribute("lista", parametrosGenerales);
            model.addAttribute("filtros", filtros != null ? filtros : new Filtros());

            return "parametrosGeneralesList";

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

        ParametrosGenerales parametroGeneral = new ParametrosGenerales();

        cargarDatos(model, request);

//        model.addAttribute("usuariosys", this.getUsuario());
        model.addAttribute("parametrosGenerales", parametroGeneral);

        return "parametrosGeneralesForm";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(@Valid ParametrosGenerales parametroGeneral, BindingResult result, ModelMap model,
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
        parametroGeneral.setUsuarioSys(getUsuario());
        model.addAttribute("filtros", new Filtros());
//		if (!Utilitarios.validarSoloLetras(estado.getDescripcion(), mensajes, model, messageSource)) {
//
//			return nuevo(model, objectosRedirigidos);
//
//		}
        try {

//            if (parametroGeneral.getParametro() == null) {

//                parametroGeneralService.guardar(parametroGeneral);
//                ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.guardado");

//            } else {

                parametroGeneralService.actualizar(parametroGeneral);
                ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.actualizado");
//            }

        } catch (Exception e) {

//			try {
//
//				new DbExceptions(e);
//
//			} catch (Throwable tx) {
//
//				model.addAttribute("estadoes", estado);
//				ManejadorMensajes.enviarMensajeError(mensajes, model, messageSource, "asd", e.getMessage());
//
//			}
//
//			return nuevo(model, objectosRedirigidos, request);
        }

        return listar(model, objectosRedirigidos, request);

    }

    @RequestMapping(value = "/eliminar/{parametro}")
    public String eliminar(@PathVariable String parametro, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

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
            ParametrosGenerales parametroGeneral = parametroGeneralService.obtenerById(parametro);

            parametroGeneralService.actualizar(parametroGeneral);
            parametroGeneralService.eliminarById(parametro);

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

    @RequestMapping(value = "/editar/{parametro}")
    public String editar(@PathVariable String parametro, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {

        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
            enviarLogIn();
            return enviarLogIn();
        }

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
        try {
            cargarDatos(model, request);

            model.addAttribute("parametrosGenerales", parametroGeneralService.obtenerById(parametro));
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

        return "parametrosGeneralesForm";

    }
}
