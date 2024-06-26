/*
 * Java classes are grouped in "packages". This allows them to be referenced and used in other
 * classes using import statements.  Any class in this project is prefixed in the com.mockcompany.webapp
 * package.
 *
 *   https://www.w3schools.com/java/java_packages.asp
 *
 * For general help with Java, see the tutorialspoint tutorial:
 *
 *   https://www.tutorialspoint.com/java/index.htm
 */
package com.mockcompany.webapp.controller;

/*
 * An import statement allows the current class to use the class being imported
 */
//import com.mockcompany.webapp.data.ProductItemRepository;
import com.mockcompany.webapp.model.ProductItem;
/* to use SearchService */
import com.mockcompany.webapp.services.SearchService;
/* The springframework package allows us to take advantage of the spring capabilities */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/* java.util package provides useful utilities */
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This class is the entrypoint for the /api/products/search API.  It is "annotated" with
 * the "RestController" annotation which tells the spring framework that it will be providing
 * API implementations.
 *
 *   https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.developing-web-applications
 *
 * An annotation is metadata that provides data about the program.  Annotations can be checked for on a class by other
 * classes.  In this case, we're telling the spring framework that the SearchController provides API capabilities.
 *
 *   https://docs.oracle.com/javase/tutorial/java/annotations/
 */
@RestController
public class SearchController {

    /**
     * This is a instance field.  It is provided by the spring framework through the constructor because of the
     * @Autowired annotation.  Autowire tells the spring framework to automatically find and use an instance of
     * the declared class when creating this class.
     */
    private final ProductItemRepository productItemRepository;

    /**
     * TODO: Declare the SearchService instead of the ProductItemRepository and update the constructor.
     *   The SearchService will need to have the ProductItemRepository declared and injected instead.
     */

    /* Refactored: compare with lines 63 - 66 */
    @Autowired
    private SearchService searchService;

//    @Autowired
//    public SearchController(ProductItemRepository productItemRepository) {
//        this.productItemRepository = productItemRepository;
//    }

    /**
     * TODO: Refactor this class by creating a new class named SearchService in the
     *   com.mockcompany.webapp.service package.  It should be annotated with @Service and contain a similar
     *   method as the one here except it will not have any API specific annotations since it is a reusable
     *   service and not an API Controller!
     *
     * The search method, annotated with @GetMapping telling spring this method should be called
     * when an HTTP GET on the path /api/products/search is made.  A single query parameter is declared
     * using the @RequestParam annotation.  The value that is passed when performing a query will be
     * in the query parameter.
     * @param query
     * @return The filtered products
     */
    @GetMapping("/api/products/search")
    public Collection<ProductItem> search(@RequestParam("query") String query) {
        return searchService.search(query);
    }

//    public Collection<ProductItem> search(@RequestParam("query") String query) {
//        Iterable<ProductItem> allItems = this.productItemRepository.findAll();
//        List<ProductItem> itemList = new ArrayList<>();

//        boolean exactMatch = false;
//        if (query.startsWith("\"") && query.endsWith("\"")) {
//            exactMatch = true;
            // Extract the quotes
//            query = query.substring(1, query.length() - 1);
//        } else {
            // Handle case-insensitivity by converting to lowercase first
//            query = query.toLowerCase();
//        }

        // For each item... This is written for simplicity to be read/understood not necessarily maintain or extend
//        for (ProductItem item : allItems) {
//            boolean nameMatches;
//            boolean descMatches;
            // Check if we are doing exact match or not
//            if (exactMatch) {
                // Check if name is an exact match
//                nameMatches = query.equals(item.getName());
                // Check if description is an exact match
//                descMatches = query.equals(item.getDescription());
//            } else {
                // We are doing a contains ignoring case check, normalize everything to lowercase
                // Check if name contains query
//                nameMatches = item.getName().toLowerCase().contains(query);
//                // Check if description contains query
//                descMatches = item.getDescription().toLowerCase().contains(query);
//            }

            // If either one matches, add to our list
//            if (nameMatches || descMatches) {
//                itemList.add(item);
//            }
//        }
//        return itemList;
//    }
}
