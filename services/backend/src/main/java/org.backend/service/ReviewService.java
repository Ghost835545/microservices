package org.backend.service;

import org.backend.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReviewService {
    Page<Review> findAll(Pageable pageable);
    Review createReview(Review review);
    List<Review> getAllReview();
    Boolean success(String id);

}
