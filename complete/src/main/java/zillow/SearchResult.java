package zillow;

/**
 * Created by jlu on 5/15/2017.
 */
public class SearchResult {

    private String street;
    private String citystatezip;
    private String result;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCitystatezip() {
        return citystatezip;
    }

    public void setCitystatezip(String citystatezip) {
        this.citystatezip = citystatezip;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
