package Controller;

import Dao.UsuarioDao;
import Model.Usuario;
import Services.Encriptar;
import Services.SessionUtils;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;

@Data
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    private Usuario usuario = new Usuario();
    private String User;
    private String Pass;

    public void startSession() throws Exception {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
            usuario = dao.startSession(User, Encriptar.encriptar(Pass));
            if (usuario != null) {
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", usuario);
                FacesContext.getCurrentInstance().getExternalContext().redirect("/Sessions/faces/index.xhtml");
            } else {
                setPass(null);
                usuario = new Usuario();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contraseña/Usuario Incorrecto"));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void jalarNombreSession() {
//        System.out.println(SessionUtils.nombreSession());
//        System.out.println(SessionUtils.apellidoSession());
    }

    public void nombreSession() {
        Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        if (us != null) {
            System.out.println(us.getApellido());
        }
    }

}
