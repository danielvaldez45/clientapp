package com.phoenix.clienteapp.productDAO;

import java.sql.*;

public class ConnectionDatabase {
   private Connection conn;

   //Este constructor solo inicializa la conexion a la base.
   public ConnectionDatabase() {
     String url = "jdbc:postgresql://localhost:5432/postgres";
     //String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
     String driver = "org.postgresql.Driver";
     String username="daniel";
     String password="mysecretpassword";
     
     try {
         //Cargamos el binario: "com.postgresql.driver".
         Class.forName(driver).newInstance();
	 //Abre un hilo de conexion a la base de datos.
         this.conn = DriverManager.getConnection(url , username, password);
      } catch (SQLException ex) {
         ex.printStackTrace();
      } catch (InstantiationException ex) {
         ex.printStackTrace();
      } catch (IllegalAccessException ex) {
         ex.printStackTrace();
      } catch (ClassNotFoundException ex) {
         ex.printStackTrace();
      }
    }  
    
    //Expone la instancia de conexion de la base.
    public Connection getConnection(){
       return this.conn;
    }

    //Funcion para cerrar la conexion a la base de datos.
}


