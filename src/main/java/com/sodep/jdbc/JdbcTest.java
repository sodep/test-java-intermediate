package com.sodep.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcTest {

    public static void main(String[] args) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/sodeptask";
        String username = "postgres";
        String password = "postgres";
        String driverName = "org.postgresql.Driver";
        Class.forName(driverName);

        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Estamos conectados al: " + conn.getMetaData().getDatabaseProductName() + " " + conn.getMetaData().getDatabaseProductVersion());
        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

        BufferedReader reader1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese nombre de columna para el where: ");

        String columnParam = reader1.readLine();
        System.out.println("columnParam: " + columnParam);

        BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese nombre del valor para la columna: ");
        String valueParam = reader1.readLine();
        System.out.println("columnParam: " + valueParam);

        String query = "select * from potluck where %s = ?";
        String finalQuery = String.format(query, columnParam);

        PreparedStatement pStatement = conn.prepareStatement(finalQuery);
        pStatement.setString(1, valueParam);
        System.out.println(pStatement);

        System.out.println("Ejecutando query...");
        ResultSet rs = pStatement.executeQuery();
        while (rs.next()) {
            String fila = String.valueOf(rs.getRow());
            String name = rs.getString("name");
            System.out.println(name);
            String food = rs.getString("food");
            System.out.println(food);
            String confirmed = rs.getString("confirmed");
            System.out.println(confirmed);
            String signup_date = rs.getString("signup_date");
            System.out.println(signup_date);
        }

        conn.close();

    }
}
