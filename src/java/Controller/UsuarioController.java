package Controller;

import Dao.UsuarioDao;
import Model.Usuario;
import Services.Encriptar;
import Services.SessionUtils;
import java.io.IOException;
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
                switch (usuario.getNivel()) {
                    case "1":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/Sessions/Vistas/Templates/Administrador.xhtml");
                        break;
                    case "2":
                        FacesContext.getCurrentInstance().getExternalContext().redirect("/Sessions/Vistas/Templates/Usuario.xhtml");
                        break;
                }
            } else {
                setPass(null);
                usuario = new Usuario();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Contraseña/Usuario Incorrecto"));
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void finishSession() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Sessions");
    }

    public void obtenerDatos() {
        System.out.println(SessionUtils.ObtenerCodigoSesion());
        System.out.println(SessionUtils.ObtenerNombreSesion());
    }

}
