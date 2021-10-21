package com.tts.TechTalentTwitter.controller;

import com.tts.TechTalentTwitter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class FollowController {

    @Autowired
    private UserService userService;


    @PostMapping("/follow/{username}")
    public String follow(@PathVariable String username,
                         HttpServletRequest request) {
        User loggedInUser = userService.getLoggedInUser();
        User userToFollow = userService.findByUsername(username);

        List<User> followers = userToFollow.getFollowers();
        followers.add(loggedInUser);
        userToFollow.setFollowers(followers);

        userService.save(userToFollow);
        return "redirect:" + request.getHeader("Referer");

    }

    @PostMapping("/unfollow/{username}")
    public String unfollow(@PathVariable String username,
                           HttpServletRequest request) {
        User loggedInUser = userService.getLoggedInUser();
        User userToUnFollow = userService.findByUsername(username);

        List<User> followers = userToUnFollow.getFollowers();
        followers.remove(loggedInUser);
        userToUnFollow.setFollowers(followers);

        userService.save(userToUnFollow);
        return "redirect:" + request.getHeader("Referer");
    }
}
