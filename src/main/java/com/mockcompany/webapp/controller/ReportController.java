package com.mockcompany.webapp.controller;

import com.mockcompany.webapp.api.SearchReportResponse;
/* inject SearchService */
import com.mockcompany.webapp.services.SearchService;
import com.mockcompany.webapp.model.ProductItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Management decided it is super important that we have lots of products that match the following terms.
 * So much so, that they would like a daily report of the number of products for each term along with the total
 * product count.
 *
 * TODO: Refactor this class by rewritting the runReport method to use the SearchService
 */
@RestController
public class ReportController {

    /**
     * The people that wrote this code didn't know about JPA Spring Repository interfaces!
     */
    private final EntityManager entityManager;

    /**
     * TODO: Declare the SearchService similar to EntityManager and add as a constructor argument
     */

    /* Refactoring */
    private final EntityManager entityManager;

    @Autowired
    private SearchService searchService;

    @Autowired
    public ReportController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @GetMapping("/api/products/report")
    public SearchReportResponse runReport() {
        // This method is rewritten to use the SearchService

        SearchReportResponse response = new SearchReportResponse();
        response.setSearchTermHits(new HashMap<>());

        // Using SearchService to get count of all products
        int count = searchService.getAllProductCount();

        // Using SearchService to get count of products matching "Cool" term
        int coolTermCount = searchService.getTermCount("Cool");

        // Using SearchService to get count of products matching "Kids" term
        int kidsTermCount = searchService.getTermCount("Kids");

        // Using SearchService to get count of products matching "Amazing" term
        int amazingTermCount = searchService.getTermCount("Amazing");

        // Using SearchService to get count of products matching "Perfect" term
        int perfectTermCount = searchService.getTermCount("Perfect");

        // Set counts in the response
        response.setProductCount(count);
        response.getSearchTermHits().put("Cool", coolTermCount);
        response.getSearchTermHits().put("Kids", kidsTermCount);
        response.getSearchTermHits().put("Amazing", amazingTermCount);
        response.getSearchTermHits().put("Perfect", perfectTermCount);

        return response;
    }
    /* end of Refactoring */

//    @Autowired
//    public ReportController(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }


//    @GetMapping("/api/products/report")
//    public SearchReportResponse runReport() {
        /** TODO: This method needs to be rewritten to use the SearchService */

//        Map<String, Integer> hits = new HashMap<>();
//        SearchReportResponse response = new SearchReportResponse();
//        response.setSearchTermHits(hits);

//        int count = this.entityManager.createQuery("SELECT item FROM ProductItem item").getResultList().size();

//        List<Number> matchingIds = new ArrayList<>();
//        matchingIds.addAll(
//                this.entityManager.createQuery("SELECT item.id from ProductItem item where item.name like '%cool%'").getResultList()
//        );
//        matchingIds.addAll(
//                this.entityManager.createQuery("SELECT item.id from ProductItem item where item.description like '%cool%'").getResultList()
//        );
//        matchingIds.addAll(
//                this.entityManager.createQuery("SELECT item.id from ProductItem item where item.name like '%Cool%'").getResultList()
//        );
//        matchingIds.addAll(
//                this.entityManager.createQuery("SELECT item.id from ProductItem item where item.description like '%cool%'").getResultList()
//        );
//        List<Number> counted = new ArrayList<>();
//        for (Number id: matchingIds) {
//            if (!counted.contains(id)) {
//                counted.add(id);
//            }
//        }

//        response.getSearchTermHits().put("Cool", counted.size());


//        response.setProductCount(count);

//        List<ProductItem> allItems = entityManager.createQuery("SELECT item FROM ProductItem item").getResultList();
//        int kidCount = 0;
//        int perfectCount = 0;
//        Pattern kidPattern = Pattern.compile("(.*)[kK][iI][dD][sS](.*)");
//        for (ProductItem item : allItems) {
//            if (kidPattern.matcher(item.getName()).matches() || kidPattern.matcher(item.getDescription()).matches()) {
//                kidCount += 1;
//            }
//            if (item.getName().toLowerCase().contains("perfect") || item.getDescription().toLowerCase().contains("perfect")) {
//                perfectCount += 1;
//            }
//        }
//        response.getSearchTermHits().put("Kids", kidCount);

//        response.getSearchTermHits().put("Amazing", entityManager.createQuery("SELECT item FROM ProductItem item where lower(concat(item.name, ' - ', item.description)) like '%amazing%'").getResultList().size());

//        hits.put("Perfect", perfectCount);

//        return response;
//    }
}
