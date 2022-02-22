/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phoenix.clienteapp.productDAO;

import com.phoenix.clienteapp.model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

public class ProductDataAccess {

    private ProductDataAccess repository;
    private Connection conn;
    private String sqlQuery;

    private List<Product> products;
    private Statement st;
    private ResultSet rs;

    final String TABLE = "PRODUCTS";

    public ProductDataAccess() {
    }

    // Crear un libro
    public void save(Product product) {
        // String table = "\"" + TABLE + "\"";
        String sql;
        sql = "INSERT INTO products "
                + "("
                + "cve_product, "
                + "product_name, "
                + "product_desc, "
                + "status"
                + ")"
                + "VALUES (?, ?, ?, ?)";
        System.out.println(sql);

        try {
            ConnectionDatabase connectDB = new ConnectionDatabase();
            conn = connectDB.getConnection();
            //Obtener el ultimo id de la tabla
            int lastId = getLastIdProduct();
            //lastId++;
            product.setId(lastId);
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            //Preparamos la consulta
            stmt.setInt(1, product.getId());
            stmt.setString(2, product.getName());
            stmt.setString(3, product.getDescription());
            stmt.setString(4, "1");
            
            if (stmt.executeUpdate() == 1) {
                System.out.println("Se inserto un registro en la base de datos");
            }

            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Product> getProducts() {
        Connection conn;
        List<Product> products = new ArrayList<>();

        String sql;
//        sql = "SELECT "
//                + "cve_product,"
//                + "product_name,"
//                + "product_desc,"
//                + "status"
        sql = "SELECT *"
                + "FROM products "
                + "where status like '1';";
        try {
            ConnectionDatabase connectDB = new ConnectionDatabase();
            conn = connectDB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                products.add(new Product(rs.getInt("cve_product"), rs.getString("product_name"), rs.getString("product_desc")));
                System.out.print(products.toString());
            }
            st.close();
            rs.close();
            // Se cierra la conexiona la base de datos.
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return products;
    }

    public Product getProductById(int id) {
        Product product = new Product();
        String sql = "SELECT * FROM " + TABLE + " where id = " + "\'" + id + "\'" + ";";
        this.setSqlQuery(sql);
        System.out.println(this.toString());
        try {
            ConnectionDatabase connectDB = new ConnectionDatabase();
            conn = connectDB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            //Recorre el ResultSet y settea los valores en un objecto product.
            while (rs.next()) {
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
            }
            st.close();
            rs.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return product;
    }

    // Recibe un objeto y arma una query.
    public void updateProduct(int id, Product product) {
        //Por seguridad es importan escapar ciertos caracteres y encerrar entre comillas simples.
        String sql;
        sql = "UPDATE  products "
                + "SET"
                + " product_name = ? ,"
                + " product_desc = ? ,"
                + " status = ? "
                + "where cve_product = ?";
        this.setSqlQuery(sql);

        ConnectionDatabase connectDB = new ConnectionDatabase();
        conn = connectDB.getConnection();
        try {
            //Preparamos la query
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, product.getName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getStatus());
            stmt.setInt(4, product.getId());
            System.out.println(stmt.toString());
            if (stmt.executeUpdate() == 1) {
                System.out.println("El registro se actualizado con exito!");
            }
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Hace un borrado fisico en la base de datos.
     *
     *
     */
    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id= ?";
        ConnectionDatabase connectDB = new ConnectionDatabase();
        conn = connectDB.getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            if (stmt.executeUpdate() == 1) {
                System.out.println("El registro se ha eliminado con exito!");
            }
            //Se cierran conenexiones
            stmt.close();
            conn.close();
            System.out.print("Se elimino el registro de la base de datos");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Hace un borrado logico en la base de datos.
     *
     *
     */
    public void deleteLogicProduct(int id) {
        //Por seguridad es importan escapar ciertos caracteres y encerrar entre comillas simples.
        String sql = "UPDATE  products SET status = 0 where cve_product = " + id;
        this.setSqlQuery(sql);

        ConnectionDatabase connectDB = new ConnectionDatabase();
        conn = connectDB.getConnection();
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            st.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    String getSqlQuery() {
        return sqlQuery;
    }

    void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    String concatStringField(String field) {
        return "\"" + field + "\"";
    }

    String concatIntField(int field) {
        return "\'" + field + "\'";
    }

    @Override
    public String toString() {
        return "SQL query: " + this.sqlQuery + "\n";
    }

    /**
     * Obtiene el ultimo id de la coleccion de productos. Suma 1 al ultimo id de
     * referencia..
     *
     */
    int getLastIdProduct() {
        int cve_product = 0;
        String sql;
        sql = "SELECT "
                + "MAX(cve_product)"
                + "FROM products "
                + "WHERE status like '1';";
        try {
            ConnectionDatabase connectDB = new ConnectionDatabase();
            conn = connectDB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            //Obtiene el id mas alto de la tabla products
            while (rs.next()) {
                cve_product = rs.getInt("max");
            }

            st.close();
            rs.close();
//            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        cve_product++;
        return cve_product;
    }
}
