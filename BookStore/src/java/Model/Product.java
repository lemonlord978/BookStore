package model;

public class Product {
    private int	id;
    private String name;
    private String image;
    private int price;
    private int	cateID;
    private String author;

    public Product() {
    }

    public Product(int id, String name, String image, int price, int cateID, String author) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.cateID = cateID;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }
    
    
}
