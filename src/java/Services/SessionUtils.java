package Services;

import Model.Usuario;
import javax.faces.context.FacesContext;

public class SessionUtils {

    public static String nombreSession() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            return us.getNombre();
        } else {
            return null;
        }
    }

    public static String apellidoSession() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            return us.getApellido();
        } else {
            return null;
        }
    }

}
