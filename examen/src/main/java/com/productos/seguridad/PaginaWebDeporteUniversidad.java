package com.productos.seguridad;
import java.sql.ResultSet;
import java.sql.*;
import java.sql.SQLException;

import com.productos.datos.*;

public class PaginaWebDeporteUniversidad {
	
	private Connection connection;
	public PaginaWebDeporteUniversidad() {
        // Inicializar la conexión a la base de datos
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_producto", "postgres", "1234");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	// Método para gestionar la información de eventos del perfil administrador
	public void gestionarEventos(int idAdministrador, String nombreEvento, Date fechaEvento, String descripcionEvento, String aficheEvento) {
        try {
            // Insertar o actualizar la información del evento
            String query = "INSERT INTO eventos (id, nombre, fecha, descripcion, afiche, id_administrador) VALUES (?, ?, ?, ?, ?, ?)" +
                    " ON DUPLICATE KEY UPDATE nombre = VALUES(nombre), fecha = VALUES(fecha), descripcion = VALUES(descripcion), afiche = VALUES(afiche)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idAdministrador);
            statement.setString(2, nombreEvento);
            statement.setDate(3, fechaEvento);
            statement.setString(4, descripcionEvento);
            statement.setString(5, aficheEvento);
            statement.setInt(6, idAdministrador);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	// Método para borrar un evento del perfil administrador
    public void borrarEvento(int idEvento) {
        try {
            // Borrar el evento
            String query = "DELETE FROM eventos WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idEvento);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 // Método para aceptar o negar una postulación del perfil administrador
    public void gestionarPostulacion(int idPostulante, String estadoPostulacion) {
        try {
            // Actualizar el estado de la postulación
            String query = "INSERT INTO postulaciones (id, id_postulante, estado) VALUES (?, ?, ?)" +
                    " ON DUPLICATE KEY UPDATE estado = VALUES(estado)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idPostulante);
            statement.setInt(2, idPostulante);
            statement.setString(3, estadoPostulacion);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 // Método para solicitar ser parte del grupo ASU desde el perfil postulante
    public void solicitarASU(int idPostulante, String informacionSolicitada, byte[] hojaVida) {
        try {
            // Insertar o actualizar la información de la solicitud
            String query = "INSERT INTO archivos_adjuntos (id, id_postulante, nombre_archivo, archivo) VALUES (?, ?, ?, ?)" +
                    " ON DUPLICATE KEY UPDATE nombre_archivo = VALUES(nombre_archivo), archivo = VALUES(archivo)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idPostulante);
            statement.setInt(2, idPostulante);
            statement.setString(3, informacionSolicitada);
            statement.setBytes(4, hojaVida);
            statement.executeUpdate();
        } catch (SQLException e) {
        e.printStackTrace();
        }
        }
    
 // Método para revisar el estado de la postulación desde el perfil postulante
    public String revisarEstadoPostulacion(int idPostulante) {
        try {
            // Obtener el estado de la postulación
            String query = "SELECT estado FROM postulaciones WHERE id_postulante = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, idPostulante);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("estado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "No encontrado";
    }
    
    
 // Método para cerrar la conexión a la base de datos
    public void cerrarConexion() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
 // Método principal para probar la funcionalidad
    public static void main(String[] args) {
        PaginaWebDeporteUniversidad paginaWeb = new PaginaWebDeporteUniversidad();

        // Ejemplo de uso de los métodos
        paginaWeb.gestionarEventos(1, "Evento 1", Date.valueOf("2023-06-01"), "Descripción del evento 1", "afiche1.jpg");
        paginaWeb.gestionarEventos(1, "Evento 2", Date.valueOf("2023-06-15"), "Descripción del evento 2", "afiche2.jpg");
        paginaWeb.borrarEvento(2);
        paginaWeb.gestionarPostulacion(3, "aceptada");
        paginaWeb.solicitarASU(4, "Información solicitada", new byte[]{});
        String estadoPostulacion = paginaWeb.revisarEstadoPostulacion(4);
        System.out.println("Estado de la postulación: " + estadoPostulacion);

        paginaWeb.cerrarConexion();
    }

   
	
}
