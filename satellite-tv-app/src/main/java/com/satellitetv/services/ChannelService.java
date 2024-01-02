package com.satellitetv.services;

import com.satellitetv.entity.Channel;
import com.satellitetv.repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ChannelService {

    @Autowired
    private ChannelRepository channelRepository;

    public Channel getChannelById(Long id)
    {
        return channelRepository.findById(id).orElse(null);
    }
}
