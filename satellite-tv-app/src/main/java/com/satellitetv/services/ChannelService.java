package com.satellitetv.services;

import com.satellitetv.entity.Channel;
import com.satellitetv.repositories.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelService {

    private ChannelRepository channelRepository;

    public Channel getChannelById(Long id)
    {
        return channelRepository.findById(id).orElse(null);
    }
}
