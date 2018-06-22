package Controller;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;

@Named(value = "demoController")
@SessionScoped
public class DemoController implements Serializable {

    private String user;

    public void inicioSession() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", user);
    }

    public void obtenerSession() {
        System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username"));
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
