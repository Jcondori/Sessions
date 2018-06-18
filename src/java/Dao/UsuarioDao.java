package Dao;

import Model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao extends DAO {

    public Usuario startSession() throws Exception {
        this.Conectar();
        ResultSet rs;
        Usuario usuario = null;
        try {
            String sql = "";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setCodigo(rs.getString(""));
                usuario.setUsuario(rs.getString(""));
                usuario.setPassword(rs.getString(""));
                usuario.setNombre(rs.getString(""));
                usuario.setApellido(rs.getString(""));
                usuario.setCodigo(rs.getString(""));
                usuario.setCodigo(rs.getString(""));
                usuario.setCodigo(rs.getString(""));
            }
            return usuario;
        } catch (SQLException e) {
            throw e;
        }
    }

}
