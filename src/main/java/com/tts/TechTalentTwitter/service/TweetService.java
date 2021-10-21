package com.tts.TechTalentTwitter.service;

import com.tts.TechTalentTwitter.model.Tweet;
import com.tts.TechTalentTwitter.model.TweetDisplay;
import com.tts.TechTalentTwitter.model.User;

import java.util.List;

public interface TweetService {
    List<TweetDisplay> findAll();
    List<TweetDisplay> findAllByUser(User user);
    List<TweetDisplay> findAllByUsers(List <User> users);
    List<TweetDisplay> findAllWithTags(String tag);
    void save(Tweet tweet);
    void handleTags(Tweet tweet);
    List<TweetDisplay> formatTweets(List<Tweet> tweets);
    void addTagLinks(List <Tweet> tweets);
    void shortLinks(List<Tweet> tweets);

    List<TweetDisplay> formatTimeStamps(List<Tweet> tweets);
}
