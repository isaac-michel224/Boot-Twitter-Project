package com.tts.TechTalentTwitter.service;

import com.tts.TechTalentTwitter.model.TweetDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetServiceImpl implements TweetService{

    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private TagRepository tagRepository;


    @Override
    public List<TweetDisplay> findAll() {
        return formatTweets(tweetRepository.findAllByOrderByCreatedAtDesc());
    }


}
