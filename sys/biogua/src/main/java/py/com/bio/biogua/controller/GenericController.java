/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.com.bio.biogua.controller;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import py.com.bio.biogua.model.Usuarios;
import py.com.bio.biogua.service.UsuariosService;
import py.com.bio.biogua.utilities.Constans;
import py.com.bio.biogua.utilities.Formated;

/**
 *
 * @author BIOST
 */
public class GenericController {

    @Autowired
    UsuariosService usuariosServices;
    
    /**
     * This method returns the principal[user-name] of logged-in user.
     *
     * @return usuario
     */
    public String getUsuario() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

//    /**
//     * Método que retorna el Nombre y Apellido del usuario logueado
//     *
//     * @return usuario
//     */
//    public String getUserName() {
//        String userName = null;
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//        if (principal instanceof UserDetails) {
//            userName = ((UserDetails) principal).getUsername();
//        } else {
//            userName = principal.toString();
//        }
//        return userName;
//    }
    /**
     * Método que envía al menú principal
     *
     * @return
     */
    public String enviarMenuPrincipal() {
        return "redirect:/menuPrincipal";
    }

    /**
     * Método que envía a la pantalla de login
     *
     * @return
     */
    public String enviarLogIn() {
        return "login";
    }
    
//    /**
//	 * Metodo que finaliza la sesion
//	 * 
//	 * @param model
//	 * @param objectosRedirigidos
//	 * @return
//	 */
//	public String enviarLogOut(ModelMap model, RedirectAttributes objectosRedirigidos) {
//
//		          ManejadorMensajes mensajes = new ManejadorMensajes();
//
//		ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);
//
//		if (Utilitarios.isNullOrEmpty(model.get("SIN_AUTORIZACION")) ? false
//				: model.get("SIN_AUTORIZACION").equals(Constantes.VERDADERO)) {
//			return "redirect:/login";
//		} else {
//			return "redirect:/login?logout";
//		}
//	}

    /**
     * Método que carga en el modelo el usuario y la ip
     *
     * @param model
     * @param request
     */
    public void cargarDatos(ModelMap model, HttpServletRequest request) {
        try {
            Usuarios usuario = usuariosServices.obtenerById(getUsuario());
            model.addAttribute("usuariosys", getUsuario());
            String user = usuario.getNombre() + " " + usuario.getApellido();
            model.addAttribute("usersysNameApe", user);
            model.addAttribute("ip", request.getRemoteAddr());
            model.addAttribute("SessionTime",request.getSession().getMaxInactiveInterval()); //segundos
            Formated f = new Formated();
            f.setDatePattern(Constans.FORMATO_FECHA_DDMMYYYY_1);
            String fecha = f.getDateFormat(new Date());
            model.addAttribute("fecha", fecha);
        } catch (Exception ex) {
            Logger.getLogger(GenericController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
