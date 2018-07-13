package Services;

import Model.Usuario;
import javax.faces.context.FacesContext;

public class SessionUtils {

    public static Usuario obtenerObjetoSesion() {
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
    }

    public static String ObtenerNombreSesion() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        return us != null ? us.getNombre() : null;
    }

    public static String ObtenerCodigoSesion() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        return us != null ? us.getCodigo() : null;
    }

}
