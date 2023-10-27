package Model;

public class Brand {
    private Integer bid;
    private String bname;

    public Brand(Integer bid, String bname) {
        this.bid = bid;
        this.bname = bname;
    }

    public Integer getBrandID() {
        return bid;
    }

    public void setBrandID(Integer bid) {
        this.bid = bid;
    }

    public String getBrandName() {
        return bname;
    }

    public void setBrandName(String bname) {
        this.bname = bname;
    }
}
