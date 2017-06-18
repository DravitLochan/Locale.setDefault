package bharathacks.com.bharatproviders;

/**
 * Created by DravitLochan on 17-06-2017.
 */

public class Item {
    String url, price, name;

    public Item(String url, String price, String name) {
        this.url = url;
        this.price = price;
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
