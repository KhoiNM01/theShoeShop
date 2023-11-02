package Model;

public class Brand {
    private int bid;
    private String bname;

    public Brand(int bid, String bname) {
        this.bid = bid;
        this.bname = bname;
    }

    public int getBrandID() {
        return bid;
    }

    public void setBrandID(int bid) {
        this.bid = bid;
    }

    public String getBrandName() {
        return bname;
    }

    public void setBrandName(String bname) {
        this.bname = bname;
    }
}
