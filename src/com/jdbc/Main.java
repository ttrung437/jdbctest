package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

    static final String url = "jdbc:mysql://localhost:3306/qlsv";
    static final String userpass = "root";

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement prepstm = null;

        try {

            con = DriverManager.getConnection(url, userpass, userpass);
            /**bien dich truoc cau sql**/
            prepstm = con.prepareStatement("update sv set ten=? where id=?");
            int a =2;
            /**tao tham so*/
            prepstm.setString(1, "Cao Thu Quynh");
            prepstm.setInt(2,  a);
            /**execute*/
            prepstm.executeUpdate();

            /**in ra ket qua*/
            ResultSet res = prepstm.executeQuery("select * from sv");
            while (res.next())
                System.out.println(res.getInt(1) + " " + res.getString(2) + " " +
                        res.getInt(3) + " " + res.getInt(4));

            res.close();
            prepstm.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (prepstm != null)
                    prepstm.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
