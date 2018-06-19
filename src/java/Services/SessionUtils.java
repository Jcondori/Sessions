package Services;

import Model.Usuario;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {

    public static HttpSession getSession() {
        return (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) FacesContext.getCurrentInstance()
                .getExternalContext().getRequest();
    }

    public static Usuario getUserName() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return (Usuario) session.getAttribute("username");
    }

    public static Usuario getUserId() {
        HttpSession session = getSession();
        if (session != null) {
            return (Usuario) session.getAttribute("userid");
        } else {
            return null;
        }
    }

}
