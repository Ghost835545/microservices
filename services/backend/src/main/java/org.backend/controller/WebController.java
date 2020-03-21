package org.backend.controller;

import org.backend.entity.Review;
import org.backend.entity.User;
import org.backend.service.ReviewService;
import org.backend.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    private final ReviewService reviewService;
    private final UserService userService;

    public WebController(ReviewService reviewService, UserService userService) {
        this.reviewService = reviewService;
        this.userService = userService;
    }


    @GetMapping("/p_r")
    public String getReport(Model model) {
        model.addAttribute("review", new Review());
        return "review/page_review";
    }

    @GetMapping("/")
    public String getAuth(Model model) {
        model.addAttribute("auth", new User());
        return "auth/authForm";
    }

    @PostMapping("/sign_in")
    public String SignIn(User user, Model model) {
        if (userService.signIn(user.getPassword(), user.getLogin())) {
            model.addAttribute("review",new Review());
            return "review/page_review";
        }
        return "dsf";

    }

    @PostMapping("/add_r")
    public String submitReport(Review review, Model model) {
        model.addAttribute("review", new Review());
        reviewService.createReview(review);
        if (reviewService.success(review.getId())) {
            return "review/post_success";
        } else {
            return "review/page_review";
        }
    }

    @GetMapping("/r_list")
    public ModelAndView getAllReview() {
        ModelAndView model = new ModelAndView("review/list_review");
        List<Review> reviewList = new ArrayList<>(reviewService.getAllReview());
        model.addObject("l_review", reviewList);
        return model;
    }
}

