package com.satellitetv.controllers;

import com.satellitetv.entity.Channel;
import com.satellitetv.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/channels")
public class ChannelController
{
    @Autowired
    private ChannelService cservice;

    @GetMapping("/{id}")
    public Channel getChannel(@PathVariable Long id)
    {
        return cservice.getChannelById(id);
    }

}
