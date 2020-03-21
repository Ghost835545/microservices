package org.backend.service.impl;

import org.backend.entity.Review;
import org.backend.repository.ReviewRepository;
import org.backend.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository){
        this.reviewRepository=reviewRepository;
    }

    @Override
    public Page<Review> findAll(Pageable pageable){
        return reviewRepository.findAll(pageable);
    }
    @Override
    public Review createReview(Review review){
        return reviewRepository.save(review);
    }
    @Override
    public List<Review> getAllReview(){
        return reviewRepository.findAll();
    }
    @Override
    public Boolean success(String id){
        return reviewRepository.existsById(id);
    }
}
