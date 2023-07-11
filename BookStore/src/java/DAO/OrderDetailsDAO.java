package DAO;

import java.util.ArrayList;
import java.util.List;
import model.OrderDetails;

public class OrderDetailsDAO extends MyDAO {

    public List<OrderDetails> getOrderItemses(int OrderID) {
        List<OrderDetails> t = new ArrayList<>();
        xSql = "select *\n"
                + "from OrderDetails od, Product p\n"
                + "where od.orderID = " + OrderID + " and od.productID = p.id";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xOderID, xProductID, xTotalPrice, xQuantity, xPrice;
            String xName, xImage;
            OrderDetails x;
            while (rs.next()) {
                xOderID = rs.getInt("orderID");
                xProductID = rs.getInt("productID");
                xTotalPrice = rs.getInt("TotalPrice");
                xQuantity = rs.getInt("Quantity");
                xName = rs.getString("name");
                xImage = rs.getString("image");
                xPrice = rs.getInt("price");
                x = new OrderDetails(xOderID, xProductID, xTotalPrice, xQuantity, xName, xImage, xPrice);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public void insert(OrderDetails x) {
        xSql = "insert into OrderDetails values (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, x.getOrderID());
            ps.setInt(2, x.getProductID());
            ps.setInt(3, x.getTotalPrice());
            ps.setInt(4, x.getQuantity());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getNumberOrderItemPage(int OrderID) {
        xSql = "select count(*)\n"
                + "from OrderDetails o, Product p\n"
                + "where o.OrderID = " + OrderID + " and o.productID = p.id";
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
}
