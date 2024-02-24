package services;
import entity.Channel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ChannelService
{
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("satellite_proj");
    EntityManager em =  emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

    @Transactional
    public List<Channel> getAllChannels() {
        Session session = em.unwrap(Session.class);
        Query<Channel> query = (Query<Channel>) session.createQuery("FROM Channel");
        return query.getResultList();
    }

    @Transactional
    public Channel getChannelById(Long id) {
        Session session = em.unwrap(Session.class);
        Query<Channel> query = (Query<Channel>) session.createQuery("FROM Channel WHERE id = :cid");
        query.setParameter("cid", id);
        return query.uniqueResult();
    }

    @Transactional
    public Channel saveChannel(Channel channel) {
        em.persist(channel);
        et.commit();
        em.close();
        return channel;
    }
}
