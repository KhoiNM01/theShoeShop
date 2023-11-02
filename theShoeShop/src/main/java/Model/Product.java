package Model;

public class Product {
    private int id;
    private String image;
    private String title;
    private String description;
    private int cateID;
    private int sell_ID;
    private String image2;
    private String image3;
    private String image4;

    public Product(int id, String image, String title, String description, int cateID, int sell_ID, String image2, String image3, String image4) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.description = description;
        this.cateID = cateID;
        this.sell_ID = sell_ID;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
    }

    public Product() {
        
    }


    public int getProductID() {
        return id;
    }

    public void setProductID(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryID() {
        return cateID;
    }

    public void setCategoryID(int cateID) {
        this.cateID = cateID;
    }

    public int getSellID() {
        return sell_ID;
    }

    public void setSellID(int sell_ID) {
        this.sell_ID = sell_ID;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }
}
