package Controller;

import Model.Usuario;
import Services.SessionUtils;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.servlet.http.HttpSession;
import lombok.Data;

@Data
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController implements Serializable {

    private Usuario usuario = new Usuario();

    public void startSession() {
        HttpSession session = SessionUtils.getSession();
        session.setAttribute("username", usuario);
    }
    
}
