package com.kermatt.guitar_api.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import com.kermatt.guitar_api.entity.Guitar;

import java.util.List;

// use criteria builder and predicates to dynamically create SQL queries, since I want the keywords to be entered and searched dynamically
    // also use conjunction to accumualte the predicates
// have a predicate for each column of the db. Go through each row and check if the condition is satisfied (in this case, if the column contains the keyword)
    // ie: in the "maker" predicate, it's like saying SELECT * FROM guitar WHERE LOWER(maker) LIKE '%keyword%'
    // by default each of these predicates are True. If they don't pass the criteria specified in the .like() param, then they are false
public class GuitarSpecification {
    public static Specification<Guitar> containsKeywords(List<String> keywords) {
        return (root, query, criteriaBuilder) -> {
            Predicate combinedPredicate = criteriaBuilder.conjunction();    // empty AND predicate, acts as a starting point

            for (String keyword : keywords) {
                Predicate makerPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("maker")), "%" + keyword.toLowerCase() + "%");
                Predicate modelPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("model")), "%" + keyword.toLowerCase() + "%");
                Predicate notableUser1Predicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("notableUser1")), "%" + keyword.toLowerCase() + "%");
                Predicate notableUser2Predicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("notableUser2")), "%" + keyword.toLowerCase() + "%");
                Predicate notableUser3Predicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("notableUser3")), "%" + keyword.toLowerCase() + "%");
                Predicate feature1Predicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("feature1")), "%" + keyword.toLowerCase() + "%");
                Predicate feature2Predicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("feature2")), "%" + keyword.toLowerCase() + "%");
                Predicate feature3Predicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("feature3")), "%" + keyword.toLowerCase() + "%");
                Predicate feature4Predicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("feature4")), "%" + keyword.toLowerCase() + "%");
                Predicate feature5Predicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("feature5")), "%" + keyword.toLowerCase() + "%");
                Predicate popularityPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("popularity")), "%" + keyword.toLowerCase() + "%");

                // create one predicate using the predicates above to filter out rows where at least one of their contain the keyword(s)
                    // if any one of the predicates are True, then the condition is satisfied meaning this row contains one or more of the keywords and is therefore included
                    // basically saying like LOWER(maker) LIKE %keyword% OR LOWER(model) LIKE %keyword%
                Predicate keywordPredicate = criteriaBuilder.or(
                    makerPredicate,
                    modelPredicate,
                    notableUser1Predicate,
                    notableUser2Predicate,
                    notableUser3Predicate,
                    feature1Predicate,
                    feature2Predicate,
                    feature3Predicate,
                    feature4Predicate,
                    feature5Predicate,
                    popularityPredicate
                );

                // further filter out the results - using the predicates which contain all the rows containing the keywords, return the predicates that contain all the keywods
                    // in other words, I have a bunch of rows that have each keyword. Now I want to put an AND in between all of them
                    // (... OR ... OR ... OR ...) AND (... OR ... OR ... OR ...)
                    // for example, when keywords are ['fender', 'stratocaster'], it's same as saying: 
                        // (SELECT * FROM GUITAR WHERE (LOWER(maker) LIKE %fender% OR LOWER(model) LIKE %fender% OR ...) )
                        // AND
                        /// (SELECT * FROM GUITAR WHERE (LOWER(maker) LIKE %stratocaster% OR LOWER(model) LIKE %stratocaster% OR ...))
                combinedPredicate = criteriaBuilder.and(combinedPredicate, keywordPredicate);
            }
            return combinedPredicate;
        };
    }
}