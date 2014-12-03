package dao;

import modelo.Empleado;
import modelo.Usuario;

import java.sql.SQLException;

/**
 * Created by Gabriel on 11/11/2014.
 */
public class DaoUsuarioEmpleado extends Dao{

    private static final String QUERY_ASIGNAR_USUARIO = "INSERT INTO " +
            "Usuarios_Empleados (idUsuario, idEmpleado) values (?, ?)";

    private static final String QUERY_RECUPERAR_INFORMACION_USUARIO = "SELECT " +
            "Empleados.* From Usuarios_Empleados INNER JOIN Empleados ON " +
            "usuarios_empleados.idEmpleado = empleados.idEmpleado INNER JOIN " +
            "Usuarios ON Usuarios_empleados.idUsuario = Usuarios.idUsuario " +
            "WHERE Usuarios.NombreUsuario = ? AND Usuarios.Clave = ?;";

    public boolean guardar(Empleado empleado, Usuario usuario) throws
            SQLException {
        int idEmpleado;
        int idUsuario;
        conexion = DaoFactory.crearConexion();
        query = conexion.prepareStatement(QUERY_ASIGNAR_USUARIO);
        DaoFactory daoFactory = new DaoFactory();
        DaoEmpleado daoEmpleado = daoFactory.obtenerDaoEmpleados();
        DaoUsuario daoUsuario= daoFactory.obtenerDaoUsuarios();

        idEmpleado = daoEmpleado.guardar(empleado);
        idUsuario = daoUsuario.guardar(usuario);
        query.setInt(1, idUsuario);
        query.setInt(2, idEmpleado);
        query.execute();

        cerrarSentencia(query);
        cerrarConexion(conexion);

        return true;
    }

    public Empleado getInformacionEmpleadoLogueado(Usuario usuario) throws SQLException{
        Empleado empleado = null;
        conexion = DaoFactory.crearConexion();
        query = conexion.prepareStatement(QUERY_RECUPERAR_INFORMACION_USUARIO);

        query.setString(1, usuario.getNombreUsuario());
        query.setString(2, usuario.getClave());
        query.execute();

        listaDeResultados = query.getResultSet();
        if (listaDeResultados.next()) {
            empleado = new Empleado();
            empleado.setIdEmpleado(listaDeResultados.getInt(1));
            empleado.setNombre(listaDeResultados.getString(2));
            empleado.setApellido(listaDeResultados.getString(3));
            empleado.setEdad(listaDeResultados.getInt(4));
            empleado.setDireccion(listaDeResultados.getString(5));
            empleado.setEmail(listaDeResultados.getString(6));
            empleado.setTelefono(listaDeResultados.getString(7));
            empleado.setSalario(listaDeResultados.getFloat(8));
            empleado.setComision(listaDeResultados.getFloat(9));
            empleado.setTipo(listaDeResultados.getString(10));
        } else {
            //Se considera el if, pero no es necesario
        }

        cerrarListaDeResultados(listaDeResultados);
        cerrarSentencia(query);
        cerrarConexion(conexion);

        return empleado;
    }

}
