package DAO;

import java.util.ArrayList;
import java.util.List;
import model.Cart;

public class CartDAO extends MyDAO {

    public List<Cart> getUserItemses(int UserID) {
        List<Cart> t = new ArrayList<>();
        xSql = "select *\n"
                + "from Cart c, Product p\n"
                + "where c.userID = " + UserID + " and c.productID = p.id";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xUserID, xProductID, xTotalPrice, xQuantity, xPrice;
            String xName, xImage;
            Cart x;
            while (rs.next()) {
                xUserID = rs.getInt("userID");
                xProductID = rs.getInt("productID");
                xTotalPrice = rs.getInt("TotalPrice");
                xQuantity = rs.getInt("Quantity");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xPrice = rs.getInt("price");
                x = new Cart(xUserID, xProductID, xTotalPrice, xQuantity, xName, xImage, xPrice);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    //insert item vao cart
    public void insert(Cart x) {
        xSql = "insert into Cart values (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, x.getUserID());
            ps.setInt(2, x.getProductID());
            ps.setInt(3, x.getTotalPrice());
            ps.setInt(4, x.getQuantity());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ////            in ra list Category (loai san pham)
    public Cart getCartItem(int UserID, int ProductID) {
        xSql = "select *\n"
                + "from Cart c, Product p\n"
                + "where c.userID = " + UserID + " and c.productID = p.id and p.id = " + ProductID;
        int xUserID, xProductID, xTotalPrice, xQuantity, xPrice;
            String xName, xImage;
        Cart x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if(rs.next()) {
                xUserID = rs.getInt("userID");
                xProductID = rs.getInt("productID");
                xTotalPrice = rs.getInt("TotalPrice");
                xQuantity = rs.getInt("Quantity");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xPrice = rs.getInt("price");
                x = new Cart(xUserID, xProductID, xTotalPrice, xQuantity, xName, xImage, xPrice);
            }
        rs.close();
        ps.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return(x);
    }
    
    //tang so luong deu da co san pham trong cart
    public void addQuan(Cart x, int Quantity, int TotalPrice){
        xSql = "update Cart set Quantity=Quantity+?, TotalPrice= TotalPrice + ? where userID=? and productID=?";
        try{
            ps = con.prepareStatement(xSql);
            ps.setInt(1, Quantity);
            ps.setInt(2, TotalPrice);
            ps.setInt(3, x.getUserID());
            ps.setInt(4, x.getProductID());
            ps.executeUpdate();
            ps.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void buy(int id) {
        xSql = "delete from Cart where userID= " + id;
        try {
            ps = con.prepareStatement(xSql);
            ps.executeUpdate();
            //con.commit();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
        public void delete(String id) {
        xSql = "delete from Cart where productID=?";
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
