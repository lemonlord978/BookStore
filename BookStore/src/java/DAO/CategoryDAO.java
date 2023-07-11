/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.Category;

/**
 *
 * @author minileisduk
 */
public class CategoryDAO extends MyDAO {

//    in ra list category có trong bảng Category 
    public List<Category> getCategorys() {
        List<Category> t = new ArrayList<>();
        xSql = "select * from Category";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xId;
            String xName;
            Category x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                x = new Category(xId, xName);
                t.add(x);
            }

            rs.close();

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

}
