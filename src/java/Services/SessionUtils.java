package Services;

import Model.Usuario;
import javax.faces.context.FacesContext;

public class SessionUtils {

    public static Usuario obtenerObjetoSesion() {
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
    }

    public static String ObtenerNombreSesion() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            return us.getNombre();
        } else {
            return null;
        }
    }

    public static String ObtenerCodigoSesion() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            return us.getCodigo();
        } else {
            return null;
        }
    }

}
