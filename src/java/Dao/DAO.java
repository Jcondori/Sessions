package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {

    private Connection cn;

    public void Conectar() throws Exception {       //Metodo con los datos de acceso
        try {
            if (cn == null) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                cn = DriverManager.getConnection("jdbc:sqlserver://sql.jcondori.com:1433;databaseName=Sessions", "root", "root");
            }
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (cn != null) {
            if (cn.isClosed() == false) {
                cn.close();
                cn = null;
            }
        }
    }

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public static void main(String[] args) throws Exception {
        DAO dao = new DAO();
        dao.Conectar();
        if (dao.getCn() != null) {
            System.out.println("conectado");
        } else {
            System.out.println("error");
        }
    }

}
