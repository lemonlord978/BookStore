/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package model;
import java.util.Date;


/**
 *
 * @author daocu
 */
public class Order {
    int OrderID;
    int UserID;
    Date date;
    int price;

    public Order(int OrderID, int UserID, int price) {
        this.OrderID = OrderID;
        this.UserID = UserID;
        this.price = price;
    }

    public Order(int UserID, int price) {
        this.UserID = UserID;
        this.price = price;
    }

    public Order(int OrderID, int UserID, Date date, int price) {
        this.OrderID = OrderID;
        this.UserID = UserID;
        this.date = date;
        this.price = price;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
