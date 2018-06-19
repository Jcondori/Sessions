package Dao;

import Model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao extends DAO {

    public Usuario startSession(String User, String Pass) throws Exception {
        this.Conectar();
        ResultSet rs;
        Usuario usuario = null;
        try {
            String sql = "Select Codigo,Nombre,Apellido,Correo,DNI,Celular from Usuarios where Usuario like ? and Pass like ? and Estado like 'A'";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            ps.setString(1, User);
            ps.setString(2, Pass);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setCodigo(rs.getString("Codigo"));
                usuario.setNombre(rs.getString("Nombre"));
                usuario.setApellido(rs.getString("Apellido"));
                usuario.setCorreo(rs.getString("Correo"));
                usuario.setDNI(rs.getString("DNI"));
                usuario.setCelular(rs.getString("Celular"));
                usuario.setUsuario(User);
                usuario.setPassword(Pass);
            }
            return usuario;
        } catch (SQLException e) {
            throw e;
        }
    }

}
