package model;

public class Cart {

    private int userID;
    private int productID;
    private int TotalPrice;
    private int Quantity;
    private String name;
    private String image;
    private int price; 
    
    
    public Cart() {
    }

    public Cart(int userID, int productID, int TotalPrice, int Quantity, String name, String image, int price) {
        this.userID = userID;
        this.productID = productID;
        this.TotalPrice = TotalPrice;
        this.Quantity = Quantity;
        this.name = name;
        this.image = image;
        this.price = price;
    }


    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }


    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    
}
