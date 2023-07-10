/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class AccountDao {

    public Account getAccountByUsernameAndPassword(String Username, String Password) throws Exception {
        try {
            Account user = new Account();
            String sql = "select * from UserTBL where Username = ? and Password = ?";
            Connection conn = new BaseDAO().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, Username);
            ps.setString(2, Password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                user.setName(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                return user;
            }

        } catch (SQLException e) {

        }
        return null;

    }

//    public static void main(String[] args) {
//        try {
//            Account u = new Account();
//            u = (getAccountByUsernameAndPassword("Admin","Admin"));
//            System.out.println(u.getDisplayname());
//        } catch (Exception ex) {
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
}
