package com.tts.TechTalentTwitter.controller;

import com.tts.TechTalentTwitter.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class TweetController {

    private UserService userService;
    private TweetService tweetService;


    public TweetController(UserService userService, TweetService tweetService) {
        this.userService = userService;
        this.tweetService = tweetService;
    }


    @GetMapping(value ={"/tweets", "/"})
    public String getFreed(@RequestParam(value="filter", required = false) String filter, Model model) {
        User loggedUser = userService.getLoggedInUser();
        List<TweetDisplay> tweets = tweetService.findAll();

        if (filter == null) {
            filter = "all";
        }

        if (filter.equalsIgnoreCase("following")) {
            List<User> following = loggedInUser.getFollowing();
            tweets = tweetService.findAllByUsers(following);
            model.addAttribute("filter", "following");

        } else {
            tweets = tweetService.findAll();
            model.addAttribute("filter", "all" );

        }

        model.addAttribute("tweetList", tweets);
        return "feed";
    }

    @GetMapping("/tweets/new")
    public String getTweetForm(Model model) {
        model.addAttribute("tweet", new Tweet());
        return "new-tweet";
    }


    @GetMapping(value = "/tweets/{tag}")
    public String getTweetsByTag(@PathVariable String tag, Model model) {
        List<TweetDisplay> tweets = tweetService.findAllWithTags(tag);
        model.addAttribute("tweetList", tweets);
        model.addAttribute("tag", tag);
        return "tagged-tweets";
    }
}
