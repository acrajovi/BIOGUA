/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.controller;

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
import py.com.bio.biogua.model.Pantallas;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.model.Modulos;
import py.com.bio.biogua.model.ModulosPantallas;
import py.com.bio.biogua.service.ModulosPantallasService;
import py.com.bio.biogua.service.ModulosService;
import py.com.bio.biogua.service.PantallasService;
import py.com.bio.biogua.utilities.ManejadorMensajes;

/**
 *
 * @author jacosta
 */
@Controller
@RequestMapping("/modulosPantallas")
public class ModulosPantallasController extends GenericController {

    @Autowired
    PantallasService pantallasService;

    @Autowired
    ModulosService modulosService;

    @Autowired
    ModulosPantallasService modulosPantallasService;

    @Autowired
    MessageSource messageSource;

//    @RequestMapping(value = {"/", "/lista"}, method = RequestMethod.GET)
//    public String listar(ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
//        cargarDatos(model, request);
//
////        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
////            enviarLogIn();
////            return enviarLogIn();
////        }
//        ManejadorMensajes mensajes = new ManejadorMensajes();
//        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
//        List<Pantallas> pantallas = new ArrayList<Pantallas>();
//
//        try {
//            pantallas = pantallasService.obtenerPantallas(null);
//
//            model.addAttribute("lista", pantallas);
//            model.addAttribute("filtros", new Filtros());
//
//            return "pantallasList";
//
//        } catch (Exception e) {
//            return this.enviarMenuPrincipal();
//        }
//
//    }
    @RequestMapping(value = {"/buscar"}, method = RequestMethod.POST)
    public String buscar(Filtros filtros, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
        cargarDatos(model, request);
//        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
//            enviarLogIn();
//            return enviarLogIn();
//        }

//        List<Pantallas> pantallas = new ArrayList<Pantallas>();
        try {

//            pantallas = pantallasService.obtenerPantallas(filtros);
//
//            model.addAttribute("lista", pantallas);
//            model.addAttribute("filtros", filtros != null ? filtros : new Filtros());
//
            Modulos modulos = modulosService.obtenerById(Integer.valueOf(filtros.getCriterio()));
            model.addAttribute("modulos", modulos);
//            Filtros filtro = new Filtros();
//            filtro.setCriterio("id");
//            filtro.setFiltro(String.valueOf(id));
//            filtro.setAproximacion(true);
            model.addAttribute("filtros", filtros != null ? filtros : new Filtros());

            model.addAttribute("pantallas", modulosPantallasService.obtenerPantallasDelModuloByIdModuloAndDescripcion(modulos.getId(), filtros.getFiltro()));
            return "modulosPantallasList";
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            return this.enviarMenuPrincipal();
            return null;
        }

    }

    @RequestMapping(value = "/nuevo/{id}", method = RequestMethod.GET)
    public String nuevo(@PathVariable Integer id, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
        cargarDatos(model, request);
//        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
//            enviarLogIn();
//            return enviarLogIn();
//        }

        ModulosPantallas modulosPantallas = new ModulosPantallas();

        model.addAttribute("modulosPantallas", modulosPantallas);
        model.addAttribute("pantallas", pantallasService.obtenerPantallas(null));
        model.addAttribute("modulos", modulosService.obtenerById(id));

        return "modulosPantallasForm";

    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(@Valid ModulosPantallas modulosPantallas, BindingResult result, ModelMap model,
            RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
        cargarDatos(model, request);
//        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
//            enviarLogIn();
//            return enviarLogIn();
//        }

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);

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
//        pantalla.setUsuarioSys(getUsuario());
//        model.addAttribute("filtros", new Filtros());
//		if (!Utilitarios.validarSoloLetras(estado.getDescripcion(), mensajes, model, messageSource)) {
//
//			return nuevo(model, objectosRedirigidos);
//
//		}
        try {

//            if (modulosPantallas.getId() == null) {
            modulosPantallas.setUsuariosys(getUsuario());
            modulosPantallasService.guardar(modulosPantallas);

//                pantallasService.guardar(modulosPantallas);
            ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.guardado");
//
//            } else {
//
//                pantallasService.actualizar(modulosPantallas);
//                ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.actualizado");
//            }
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

//        return "modulosPantallas/pantallasDelModulo/4";
        return pantallasDelModulo(modulosPantallas.getModulos().getId(), model, objectosRedirigidos, request);

    }

//    @RequestMapping(value = "/eliminar/{id}")
//    public String eliminar(@PathVariable Integer id, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
//        cargarDatos(model, request);
////        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
////            enviarLogIn();
////            return enviarLogIn();
////        }
//        ManejadorMensajes mensajes = new ManejadorMensajes();
//        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
//        try {
//
//            /**
//             * REGISTRA EN LA AUDITORIA EL USUARIO QUE ELIMINO EL REGISTRO *
//             */
//            Pantallas pantalla = pantallasService.obtenerById(id);
//
//            pantallasService.actualizar(pantalla);
//            pantallasService.eliminarById(id);
//
//            ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.eliminado");
//
//        } catch (Exception e) {
//
////			try {
////
//////				new DbExceptions(Utilitarios.validarEliminacion(e));
////
////			} catch (Throwable tx) {
////
////				MensajesMetodos.enviarMensajeError(mensajes, model, messageSource, getFormulario(), tx.getMessage());
////
////			}
//        }
//
//        return listar(model, objectosRedirigidos, request);
//    }
//
//    @RequestMapping(value = "/editar/{id}")
//    public String editar(@PathVariable Integer id, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
//        cargarDatos(model, request);
////        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
////            enviarLogIn();
////            return enviarLogIn();
////        }
//
//        ManejadorMensajes mensajes = new ManejadorMensajes();
//        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
//        try {
//
//            model.addAttribute("pantallas", pantallasService.obtenerById(id));
//            ManejadorMensajes.enviarMensajeWarning(mensajes, model, messageSource, "mensajes.editando");
//
//        } catch (Exception e) {
////
////			try {
////
////				new DbExceptions(e);
////
////			} catch (Throwable tx) {
////
////				MensajesMetodos.enviarMensajeError(mensajes, model, messageSource, getFormulario(), tx.getMessage());
////
////			}
//
//        }
//
//        return "pantallasForm";
//
//    }
    @RequestMapping(value = "/pantallasDelModulo/{id}")
    public String pantallasDelModulo(@PathVariable Integer id, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
        cargarDatos(model, request);

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
        try {

//            model.addAttribute("modulosPantallas", modulosPantallasService.obtenerModulosPantallasByIdModulo(id));
            model.addAttribute("modulos", modulosService.obtenerById(id));
//            Filtros filtro = new Filtros();
//            filtro.setCriterio("id");
//            filtro.setFiltro(String.valueOf(id));
//            filtro.setAproximacion(true);
            model.addAttribute("filtros", new Filtros());
            model.addAttribute("pantallas", modulosPantallasService.obtenerPantallasDelModuloByIdModulo(id));

            ManejadorMensajes.redirigirMensajeWarning(mensajes, objectosRedirigidos, messageSource, "mensajes.editando");
        } catch (Exception e) {
        }
        return "modulosPantallasList";
    }
}
