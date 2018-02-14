package tr.edu.trakya.denizterzi.pharmacyonduty;

/**
 * Created by user on 1/19/2018.
 */

public class PharmacyModel {
    private String name;
    private String address;
    private String tel;
    private String region;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
