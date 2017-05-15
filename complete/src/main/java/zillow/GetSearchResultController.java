package zillow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GetSearchResultController {

    @Autowired
    private GetSearchResultService getSearchResultService;

    private static Logger logger = LoggerFactory.getLogger(GetSearchResultController.class);

    @GetMapping("/getSearchResult")
    public String getSearchResult(Model model) {
        model.addAttribute("searchResult", new SearchResult());
        return "getSearchResult";
    }

    @PostMapping(value = "/getSearchResult")
    public String greeting(@ModelAttribute("searchResult") SearchResult searchResult) {
        String result = getSearchResultService.getSearchResult(
                searchResult.getStreet(), searchResult.getCitystatezip());
        logger.info("{},{} has result {}", searchResult.getResult(), searchResult.getCitystatezip(), result);
        searchResult.setResult(result);
        return "result";
    }

}
