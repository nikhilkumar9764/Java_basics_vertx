package com.satellitetv.repositories;
import com.satellitetv.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ChannelRepository extends JpaRepository<Channel, Long>
{
    Optional<Channel> findById(Long id);
}
