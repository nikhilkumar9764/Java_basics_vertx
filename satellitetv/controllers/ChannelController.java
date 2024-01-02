package satellitetv.controllers;
import org.springframework.web.bind.annotation.*;
import satellitetv.entity.Channel;
import satellitetv.services.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("channels")
public class ChannelController
{
    private ChannelService cservice;

    @Autowired
    public ChannelController(ChannelService cservice) {
        this.cservice = cservice;
    }

    @GetMapping("/list")
    public List<Channel> getlist()
    {
        return cservice.get();
    }

    @GetMapping("/{id}")
    public Channel getChannel(@PathVariable Long id)
    {
        return cservice.getChannelById(id);
    }

    @PostMapping("/save")
    public Channel save(@RequestBody Channel c1)
    {
        return cservice.saveChannel(c1);
    }

}
