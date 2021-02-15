package py.com.bio.biogua.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import py.com.bio.biogua.model.Mensajes;

public class ManejadorMensajes {

    List<Mensajes> mensajes = new ArrayList<Mensajes>();

    public void satisfactorio(String pMensaje) {

        Mensajes mensaje = new Mensajes();
        mensaje.setTipo("success");
        mensaje.setMensaje(pMensaje);
        mensajes.add(mensaje);
    }

    public void informacion(String pMensaje) {

        Mensajes mensaje = new Mensajes();
        mensaje.setTipo("info");
        mensaje.setMensaje(pMensaje);
        mensajes.add(mensaje);
    }

    public void advertencia(String pMensaje) {

        Mensajes mensaje = new Mensajes();
        mensaje.setTipo("warn");
        mensaje.setMensaje(pMensaje);
        mensajes.add(mensaje);
    }

    public void error(String pMensaje) {

        Mensajes mensaje = new Mensajes();
        mensaje.setTipo("error");
        mensaje.setMensaje(pMensaje);
        mensajes.add(mensaje);
    }

    public List<Mensajes> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<Mensajes> mensajes) {
        this.mensajes = mensajes;
    }

    /**
     * Registrar el mensaje de tipo {@code SUCCESS} para propagarlo.
     *
     * @param mensajes
     * @param model
     * @param messageSource
     * @param mensaje
     */
    public static void enviarMensajeSuccess(ManejadorMensajes mensajes, ModelMap model, MessageSource messageSource,
            String mensaje) {

        ManejadorMensajes mensajesMetodos = new ManejadorMensajes();
        List<Mensajes> listaMensajes = new ArrayList<Mensajes>();

        mensajesMetodos.satisfactorio(messageSource.getMessage(mensaje, null, Locale.getDefault()));

        listaMensajes.addAll(mensajesMetodos.getMensajes());
        listaMensajes.addAll(ManejadorMensajes.obtenerMensajes(mensajes, model));

        model.addAttribute("mensajes", listaMensajes);
        model.addAttribute("mostrarMensaje", true);

    }

    /**
     * Registrar el mensaje de tipo {@code ERROR} para propagarlo.
     *
     * @param mensajes
     * @param model
     * @param messageSource
     * @param origen
     * @param mensaje
     */
    public static void enviarMensajeError(ManejadorMensajes mensajes, ModelMap model, MessageSource messageSource,
            String origen, String mensaje) {

        ManejadorMensajes mensajesMetodos = new ManejadorMensajes();
        List<Mensajes> listaMensajes = new ArrayList<Mensajes>();

        mensajesMetodos
                .error(messageSource.getMessage("form.error", new String[]{origen, mensaje}, Locale.getDefault()));

        listaMensajes.addAll(mensajesMetodos.getMensajes());
        listaMensajes.addAll(ManejadorMensajes.obtenerMensajes(mensajes, model));

        model.addAttribute("mensajes", listaMensajes);
        model.addAttribute("mostrarMensaje", true);

    }

    /**
     * Registrar el mensaje de tipo {@code WARNING} para propagarlo.
     *
     * @param mensajes
     * @param model
     * @param messageSource
     * @param mensaje
     */
    public static void enviarMensajeWarning(ManejadorMensajes mensajes, ModelMap model, MessageSource messageSource,
            String mensaje) {

        ManejadorMensajes mensajesMetodos = new ManejadorMensajes();
        List<Mensajes> listaMensajes = new ArrayList<Mensajes>();

        mensajesMetodos.advertencia(messageSource.getMessage(mensaje, null, Locale.getDefault()));

        listaMensajes.addAll(mensajesMetodos.getMensajes());
        listaMensajes.addAll(ManejadorMensajes.obtenerMensajes(mensajes, model));

        model.addAttribute("mensajes", listaMensajes);
        model.addAttribute("mostrarMensaje", true);

    }

    /**
     * Registrar el mensaje de tipo {@code INFO} para propagarlo.
     *
     * @param mensajes
     * @param model
     * @param messageSource
     * @param mensaje
     */
    public static void enviarMensajeInfo(ManejadorMensajes mensajes, ModelMap model, MessageSource messageSource,
            String mensaje) {

        ManejadorMensajes mensajesMetodos = new ManejadorMensajes();
        List<Mensajes> listaMensajes = new ArrayList<Mensajes>();

        mensajesMetodos.informacion(messageSource.getMessage(mensaje, null, Locale.getDefault()));

        listaMensajes.addAll(mensajesMetodos.getMensajes());
        listaMensajes.addAll(ManejadorMensajes.obtenerMensajes(mensajes, model));

        model.addAttribute("mensajes", listaMensajes);
        model.addAttribute("mostrarMensaje", true);

    }

    /**
     * Registrar el mensaje de tipo {@code INFO} para redirigirlo.
     *
     * @param mensajes
     * @param messageSource
     * @param mensaje
     * @param objectosRedirigidos
     */
    public static void redirigirMensajeInfo(ManejadorMensajes mensajes, RedirectAttributes objectosRedirigidos,
            MessageSource messageSource, String mensaje) {

        mensajes.informacion(messageSource.getMessage(mensaje, null, Locale.getDefault()));

        objectosRedirigidos.addFlashAttribute("mensajes", mensajes.getMensajes());
        objectosRedirigidos.addFlashAttribute("mostrarMensaje", true);

    }

    /**
     * Registrar el mensaje de tipo {@code ERROR} para redirigirlo.
     *
     * @param mensajes
     * @param objectosRedirigidos
     * @param messageSource
     * @param origen
     * @param mensaje
     */
    public static void redirigirMensajeError(ManejadorMensajes mensajes, RedirectAttributes objectosRedirigidos,
            MessageSource messageSource, String origen, String mensaje) {

        mensajes.error(messageSource.getMessage("form.error", new String[]{origen, mensaje}, Locale.getDefault()));

        objectosRedirigidos.addFlashAttribute("mensajes", mensajes.getMensajes());
        objectosRedirigidos.addFlashAttribute("mostrarMensaje", true);

    }

    /**
     * Registrar el mensaje de tipo {@code ERROR} para redirigirlo.
     *
     * @param mensajes
     * @param objectosRedirigidos
     */
    public static void redirigirMensajes(ModelMap model, RedirectAttributes objectosRedirigidos, String formulario) {

        if (model.get("mensajes") != null) {

            List<Mensajes> mensajes = new ArrayList<Mensajes>();

            Mensajes mensaje = new Mensajes();

            mensaje.setTipo("success");
            mensaje.setMensaje(formulario);

            mensajes.add(mensaje);
            mensajes.addAll((List<Mensajes>) model.get("mensajes"));

            objectosRedirigidos.addFlashAttribute("mensajes", mensajes);
            objectosRedirigidos.addFlashAttribute("mostrarMensaje", true);

        }

    }

    /**
     * Registrar el mensaje de tipo {@code WARNING} para redirigirlo.
     *
     * @param mensajes
     * @param objectosRedirigidos
     * @param messageSource
     * @param mensaje
     */
    public static void redirigirMensajeWarning(ManejadorMensajes mensajes, RedirectAttributes objectosRedirigidos,
            MessageSource messageSource, String mensaje) {

        mensajes.advertencia(messageSource.getMessage(mensaje, null, Locale.getDefault()));

        objectosRedirigidos.addFlashAttribute("mensajes", mensajes.getMensajes());
        objectosRedirigidos.addFlashAttribute("mostrarMensaje", true);

    }

    /**
     * Registrar el mensaje de tipo {@code SUCCESS} para redirigirlo.
     *
     * @param mensajes
     * @param objectosRedirigidos
     * @param messageSource
     * @param mensaje
     */
    public static void redirigirMensajeSuccess(ManejadorMensajes mensajes, RedirectAttributes objectosRedirigidos,
            MessageSource messageSource, String mensaje) {

        mensajes.satisfactorio(messageSource.getMessage(mensaje, null, Locale.getDefault()));

        objectosRedirigidos.addFlashAttribute("mensajes", mensajes.getMensajes());
        objectosRedirigidos.addFlashAttribute("mostrarMensaje", true);

    }

    /**
     * Registra en el modelo actual los mensajes redirigidos.
     *
     * @param mensajes
     * @param model
     */
    @SuppressWarnings("unchecked")
    public static void obtenerMensajesRedirigidos(ManejadorMensajes mensajes, ModelMap model) {

        if (model.get("mensajes") != null) {

            mensajes.setMensajes((List<Mensajes>) model.get("mensajes"));

        }

    }

    /**
     * Devuelve un objeto {@code List<Mensajes>} extraido de {@code mensajes}
     *
     * @param mensajes
     * @param model
     */
    @SuppressWarnings("unchecked")
    public static List<Mensajes> obtenerMensajes(ManejadorMensajes mensajes, ModelMap model) {

        if (model.get("mensajes") != null) {

            return ((List<Mensajes>) model.get("mensajes"));

        } else {

            return new ArrayList<Mensajes>();

        }

    }

    /**
     * Registrar el mensaje de tipo {@code ERROR} para redirigirlo e informar
     * que no tiene autorizacion para acceder a la pagina solicitada.
     *
     * @param mensajes
     * @param objectosRedirigidos
     * @param messageSource
     * @param mensaje
     */
    public static void redirigirMensajeNoAutorizado(ManejadorMensajes mensajes, RedirectAttributes objectosRedirigidos,
            MessageSource messageSource, String mensaje) {

        mensajes.error(messageSource.getMessage(mensaje, null, Locale.getDefault()));

        objectosRedirigidos.addFlashAttribute("mensajes", mensajes.getMensajes());
        objectosRedirigidos.addFlashAttribute("mostrarMensaje", true);

    }

    /**
     * Registrar el mensaje de tipo {@code ERROR} para redirigirlo e informar
     * que no tiene autorizacion para acceder a la pagina solicitada.
     *
     * @param mensajes
     * @param objectosRedirigidos
     * @param messageSource
     * @param mensaje
     */
    public static void redirigirMensajeNoAutorizadoModelAndView(ManejadorMensajes mensajes,
            RedirectAttributes objectosRedirigidos, MessageSource messageSource, String mensaje, ModelAndView modeloVista) {

        mensajes.error(messageSource.getMessage(mensaje, null, Locale.getDefault()));

        modeloVista.addObject("mensajes", mensajes.getMensajes());
        modeloVista.addObject("mostrarMensaje", true);

    }

}
