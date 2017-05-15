package zillow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jlu on 5/15/2017.
 */
@Service("GetSearchResultService")
public class GetSearchResultService {

    private static String zillow_url = "http://www.zillow.com/webservice/GetSearchResults.htm";
    private static String zillow_key = "X1-ZWz1dyb53fdhjf_6jziz";

    private static Logger logger = LoggerFactory.getLogger(GetSearchResultService.class);

    public String getSearchResult(String street, String citystatezip) {
        StringBuffer url = new StringBuffer();
        url.append(zillow_url).append("?zws-id=").append(zillow_key)
                .append("&address=").append(street)
                .append("&citystatezip=").append(citystatezip);

        logger.info(url.toString());

        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.getForObject(url.toString(), String.class);
        } catch (Exception e) {
            logger.error("error getting result:", e);
        }

        return "";
    }
}
