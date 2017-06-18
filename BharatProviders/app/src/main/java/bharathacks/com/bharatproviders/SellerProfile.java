package bharathacks.com.bharatproviders;

/**
 * Created by DravitLochan on 17-06-2017.
 */

public class SellerProfile {
    String id, owner_name, shop_name, contact_number, address;

    public SellerProfile(String id, String owner_name, String shop_name, String contact_number, String address) {
        this.id = id;
        this.owner_name = owner_name;
        this.shop_name = shop_name;
        this.contact_number = contact_number;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
