package com.kermatt.guitar_api.specification;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import com.kermatt.guitar_api.entity.Guitar;

import java.util.List;

public class GuitarSpecification {
    public static Specification<Guitar> containsKeywords(List<String> keywords) {
        return (root, query, criteriaBuilder) -> {
            // Start with a conjunction (AND) for all conditions
            Predicate combinedPredicate = criteriaBuilder.conjunction();

            for (String keyword : keywords) {
                // Use "or" conditions for all the columns
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

                // Combine all column predicates with OR logic for the current keyword
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

                // Add the current keyword condition to the combined predicate with AND logic
                combinedPredicate = criteriaBuilder.and(combinedPredicate, keywordPredicate);
            }

            return combinedPredicate;
        };
    }
}
