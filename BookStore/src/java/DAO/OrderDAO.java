package DAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Order;
import model.OrderDetails;

public class OrderDAO extends MyDAO {

    public List<Order> getOrders(int UserID) {
        List<Order> t = new ArrayList<>();
        xSql = "select * from Orders where userID = " + UserID + "";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xOderID, xUserID, xPrice;
            Date xDate;
            Order x;
            while (rs.next()) {
                xOderID = rs.getInt("orderID");
                xUserID = rs.getInt("userID");
                xPrice = rs.getInt("Price");
                xDate = rs.getDate("Date");
                x = new Order(xOderID, xUserID, xDate, xPrice);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public void insert(Order x) {
        xSql = "insert into Orders(userID,Price) values (?, ?)";
        
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, x.getUserID());
            ps.setInt(2, x.getPrice());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNumberOrdersPage(int UserID) {
        xSql = "select count(*)\n"
                + "from OrderDetails\n"
                + "where UserID = " + UserID;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            OrderDetails x;
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total/8;
                if(total % 8 != 0){
                    countPage++;
                }
                return countPage;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public Order GetLatestOrder(){
        xSql = "select top 1 * from Orders order by orderID desc";
        int xUserID, xOrderID, xPrice;
        Date xDate;
        Order x = null;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if(rs.next()) {
                xUserID = rs.getInt("userID");
                xOrderID = rs.getInt("orderID");
                xPrice = rs.getInt("Price");
                xDate = rs.getDate("Date");
                x = new Order(xOrderID,xUserID,xDate,xPrice);
            }
        rs.close();
        ps.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return(x);
    }
    
    public void addPrice(Order x, int TotalPrice){
        xSql = "update Orders set Price = ? where userID=? and orderID=?";
        try{
            ps = con.prepareStatement(xSql);
            ps.setInt(1, TotalPrice);
            ps.setInt(2, x.getUserID());
            ps.setInt(3, x.getOrderID());
            ps.executeUpdate();
            ps.close();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
