package py.com.bio.biogua.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import py.com.bio.biogua.model.ParametrosGenerales;
import py.com.bio.biogua.model.Usuarios;
import py.com.bio.biogua.service.ParametrosGeneralesService;
import py.com.bio.biogua.service.UsuariosService;
import py.com.bio.biogua.utilities.Constans;
import py.com.bio.biogua.utilities.ManejadorMensajes;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")
public class AppController extends GenericController {

    @Autowired
    UsuariosService usuariosService;

    @Autowired
    ParametrosGeneralesService parametrosGeneralesService;

    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;

    /**
     * This method will list all existing users.
     *
     * @param model
     * @param request
     * @return >>menuPrincipal
     */
    @RequestMapping(value = {"/menuPrincipal"}, method = RequestMethod.GET)
    public String homePage(ModelMap model, HttpServletRequest request) {

//        if (getUsuario().equals(Constans.USUARIO_ANONIMO)) {
//            enviarLogIn();
//            return enviarLogIn();
//        }
        gestionarSessiones(request);
        cargarDatos(model, request);
        return "menuPrincipal";
    }

    /**
     * This method will provide UserProfile list to views
     */
//    @ModelAttribute("roles")
//    public List<UserProfile> initializeProfiles() {
//        return userProfileService.findAll();
//    }
    /**
     * This method handles Access-Denied redirect.
     */
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getUsuario());
        return "accessDenied";
    }

    /**
     * Si ya está logueado envia a la pantalla de menu principal, si no está
     * logueado envia a la pantalla de login
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(ModelMap model, HttpServletRequest request) {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
//            return "redirect:/list";
            return this.enviarMenuPrincipal();
        }
    }

    /**
     * This method handles logout requests. Toggle the handlers if you are
     * RememberMe functionality is useless in your app.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(ModelMap model, RedirectAttributes objectosRedirigidos, HttpServletRequest request, HttpServletResponse response) {
        ManejadorMensajes mensajes = new ManejadorMensajes();

        ManejadorMensajes.obtenerMensajesRedirigidos(mensajes, model);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
//            new SecurityContextLogoutHandler().logout(request, response, auth);
            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
//        return this.enviarLogOut(model, objectosRedirigidos);
    }

    /**
     * This method returns true if users is already authenticated [logged-in],
     * else false.
     */
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }

    public void gestionarSessiones(HttpServletRequest request) {

        try {

            HttpSession session = request.getSession();

            Usuarios usuario = usuariosService.obtenerById(getUsuario());
            ParametrosGenerales parametroGeneral = parametrosGeneralesService.obtenerById(Constans.PG_TIEMPO_MAX_INACTIVIDAD);

            usuario.setLogin_hash(session.getId());
            usuario.setIpacceso(request.getRemoteAddr());

            usuariosService.actualizar(usuario);

            session.setAttribute("user", usuario.getNombre() + " " + usuario.getApellido() + " (" + request.getRemoteAddr() + ")");
            session.setMaxInactiveInterval(60 * Integer.parseInt(parametroGeneral.getValor()));

        } catch (Exception ex) {

            System.out.println("Se produjo un Error al Gestionar la Sesion del Usuario" + ex);

        }
    }
}
