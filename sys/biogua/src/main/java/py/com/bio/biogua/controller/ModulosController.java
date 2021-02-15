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
import py.com.bio.biogua.model.Modulos;
import py.com.bio.biogua.model.Filtros;
import py.com.bio.biogua.service.ModulosService;
import py.com.bio.biogua.service.PantallasService;
import py.com.bio.biogua.utilities.ManejadorMensajes;

/**
 *
 * @author jacosta
 */
@Controller
@RequestMapping("/modulos")
public class ModulosController extends GenericController {

    @Autowired
    ModulosService modulosService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/", "/lista"}, method = RequestMethod.GET)
    public String listar(ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
        cargarDatos(model, request);
        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
        List<Modulos> modulos = new ArrayList<Modulos>();

        try {
            modulos = modulosService.obtenerModulos(null);

            model.addAttribute("lista", modulos);
            model.addAttribute("filtros", new Filtros());

            return "modulosList";

        } catch (Exception e) {
            return this.enviarMenuPrincipal();
        }

    }

    @RequestMapping(value = {"/buscar"}, method = RequestMethod.POST)
    public String buscar(Filtros filtros, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
        cargarDatos(model, request);

        List<Modulos> modulos = new ArrayList<Modulos>();

        try {

            modulos = modulosService.obtenerModulos(filtros);

            model.addAttribute("lista", modulos);
            model.addAttribute("filtros", filtros != null ? filtros : new Filtros());

            return "modulosList";

        } catch (Exception e) {

            return this.enviarMenuPrincipal();

        }

    }

    @RequestMapping(value = "/nuevo", method = RequestMethod.GET)
    public String nuevo(ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
        cargarDatos(model, request);
        Modulos modulo = new Modulos();
        model.addAttribute("modulos", modulo);
        return "modulosForm";
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(@Valid Modulos modulo, BindingResult result, ModelMap model,
            RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
        cargarDatos(model, request);

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);

        modulo.setUsuariosys(getUsuario());
        model.addAttribute("filtros", new Filtros());

        try {

            if (modulo.getId() == null) {

                modulosService.guardar(modulo);
                ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.guardado");

            } else {

                modulosService.actualizar(modulo);
                ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.actualizado");
            }

        } catch (Exception e) {
        }

        return listar(model, objectosRedirigidos, request);

    }

    @RequestMapping(value = "/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
        cargarDatos(model, request);
        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
        try {

            Modulos modulo = modulosService.obtenerById(id);

            modulosService.actualizar(modulo);
            modulosService.eliminarById(id);

            ManejadorMensajes.enviarMensajeSuccess(mensajes, model, messageSource, "mensajes.eliminado");

        } catch (Exception e) {
        }
        return listar(model, objectosRedirigidos, request);
    }

    @RequestMapping(value = "/editar/{id}")
    public String editar(@PathVariable Integer id, ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request) {
        cargarDatos(model, request);

        ManejadorMensajes mensajes = new ManejadorMensajes();
        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
        try {

            model.addAttribute("modulos", modulosService.obtenerById(id));
            ManejadorMensajes.enviarMensajeWarning(mensajes, model, messageSource, "mensajes.editando");

        } catch (Exception e) {
        }
        return "modulosForm";
    }

}
