package com.example.GoReview.repositories;

import com.example.GoReview.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByUserId(long id);

    List<Review> findAllByUserUsername(String username);

    @Query("SELECT r FROM reviews r JOIN r.diets d WHERE d=?1")
    List<Review> findByDiet(Diet diet);

    @Query("SELECT r FROM reviews r JOIN r.accessibilities a WHERE a=?1")
    List<Review> findByAccessibility(Accessibility accessibility);


    @Query("SELECT r FROM reviews r WHERE pricing=?1")
    List<Review> findByPricing(Pricing pricing);

    @Query("SELECT r FROM reviews r WHERE rating=?1")
    List<Review> findByRating(Rating rating);


    List<Review> findAllByRestaurantId(long id);
}


