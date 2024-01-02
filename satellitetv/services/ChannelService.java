package satellitetv.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import satellitetv.entity.Channel;
import satellitetv.repositories.ChannelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencedb");
    @Autowired
    private EntityManager em = emf.createEntityManager();
    private ChannelRepository channelRepository;

    @Transactional
    public List<Channel> get()
    {
        Session s1 = em.unwrap(Session.class);
        Query<Channel> q1 = (Query<Channel>) s1.createQuery("from Channel");
        List<Channel> l1= q1.getResultList();
        return l1;
    }

    @Transactional
    public Channel getChannelById(Long id)
    {
        Session s1 = em.unwrap(Session.class);
        Query<Channel> q1 = (Query<Channel>) s1.createQuery("Select * from Channel where id=:cid");
        q1.setParameter("cid",id);
        Channel x1 = q1.getSingleResult();
        return x1;
    }

    @Transactional
    public Channel saveChannel(Channel c) {
        em.persist(c);
        return c;
    }
}
