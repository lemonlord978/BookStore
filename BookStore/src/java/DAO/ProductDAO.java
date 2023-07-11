/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *
 * @author minileisduk
 */
public class ProductDAO extends MyDAO {

    //in ra list product có trong bảng Product 
    public List<Product> getProducts() {
        List<Product> t = new ArrayList<>();
        xSql = "select * from Product order by id desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xId;
            String xName;
            String xImage;
            int xPrice;
            int xCateID;
            Product x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xPrice = rs.getInt("price");
                xCateID = rs.getInt("cateID");
                x = new Product(xId, xName, xImage, xPrice, xCateID);
                t.add(x);
            }

            rs.close();

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

        //in ra list product có trong bảng Product theo ten
    public List<Product> getProductsByName(String xxName) {
        List<Product> t = new ArrayList<>();
        xSql = "select * from Product where name like '%" + xxName + "%'";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xId;
            String xName;
            String xImage;
            int xPrice;
            int xCateID;
            Product x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xPrice = rs.getInt("price");
                xCateID = rs.getInt("cateID");
                x = new Product(xId, xName, xImage, xPrice, xCateID);
                t.add(x);
            }

            rs.close();

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    //in ra 5 product có trong bảng Product, sắp xếp theo mới nhất đến cũ nhất
    public List<Product> getNewestProductsBy5() {
        List<Product> t = new ArrayList<>();
        xSql = "SELECT * FROM Product\n"
                + "WHERE \n"
                + "ID > (SELECT COUNT(*) FROM Product) - 5\n"
                + "order by id desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xId;
            String xName;
            String xImage;
            int xPrice;
            int xCateID;
            Product x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xPrice = rs.getInt("price");
                xCateID = rs.getInt("cateID");
                x = new Product(xId, xName, xImage, xPrice, xCateID);
                t.add(x);
            }

            rs.close();

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    //print list of Product by category ID
    public List<Product> getProductsByCID(String cid) {
        List<Product> t = new ArrayList<>();
        xSql = "SELECT * FROM Product\n"
                + "Where cateID = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, cid);
            rs = ps.executeQuery();
            int xId;
            String xName;
            String xImage;
            int xPrice;
            int xCateID;
            Product x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xPrice = rs.getInt("price");
                xCateID = rs.getInt("cateID");
                x = new Product(xId, xName, xImage, xPrice, xCateID);
                t.add(x);
            }

            rs.close();

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    //print 1 product by id
    public Product getProduct(String xId) {
        Product x = null;
        int i = Integer.parseInt(xId);
        xSql = "select * from Product where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            String xName;
            String xImage;
            int xPrice;
            int xCateID;
            while (rs.next()) {
                i = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xPrice = rs.getInt("price");
                xCateID = rs.getInt("cateID");
                x = new Product(i, xName, xImage, xPrice, xCateID);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    //SORT
    //sort by price: low to ig
    public List<Product> getProductsLowToHigh() {
        List<Product> t = new ArrayList<>();
        xSql = "Select * from Product\n"
                + "order by price";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xId;
            String xName;
            String xImage;
            int xPrice;
            int xCateID;
            Product x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xPrice = rs.getInt("price");
                xCateID = rs.getInt("cateID");
                x = new Product(xId, xName, xImage, xPrice, xCateID);
                t.add(x);
            }

            rs.close();

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    //sort by price: high to low
    public List<Product> getProductsHighToLow() {
        List<Product> t = new ArrayList<>();
        xSql = "Select * from Product\n"
                + "order by price desc";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xId;
            String xName;
            String xImage;
            int xPrice;
            int xCateID;
            Product x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xPrice = rs.getInt("price");
                xCateID = rs.getInt("cateID");
                x = new Product(xId, xName, xImage, xPrice, xCateID);
                t.add(x);
            }

            rs.close();

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    //sap xep theo san pham cu den moi
    public List<Product> getLastestProducts() {
        List<Product> t = new ArrayList<>();
        xSql = "Select * from Product\n"
                + "order by id";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xId;
            String xName;
            String xImage;
            int xPrice;
            int xCateID;
            Product x;
            while (rs.next()) {
                xId = rs.getInt("id");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xPrice = rs.getInt("price");
                xCateID = rs.getInt("cateID");
                x = new Product(xId, xName, xImage, xPrice, xCateID);
                t.add(x);
            }

            rs.close();

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    
    //insert a product
    
    public String InsertPr(Product pr){
        try{
            xSql = "INSERT INTO Product(name, image, price, cateID) VALUES (?,?,?,?)";
            ps = con.prepareStatement(xSql);
            ps.setString(1, pr.getName());
            ps.setString(2, pr.getImage());
            ps.setInt(3, pr.getPrice());
            ps.setInt(4, pr.getCateID());
            ps.executeUpdate();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return "true";
    }
    
    
    //Update a product
    public void update(int id, Product x){
        xSql = "update Product set name=?, image=?,price=?, cateID=? where id=?";
        try{
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getName());
            ps.setString(2, x.getImage());
            ps.setInt(3, x.getPrice());
            ps.setInt(4, x.getCateID());
            ps.setInt(5, x.getId());
            ps.executeUpdate();
            ps.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Delete a product
    public void delete(String id) {
        xSql = "delete from Product where id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            ps.executeUpdate();
            //con.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
