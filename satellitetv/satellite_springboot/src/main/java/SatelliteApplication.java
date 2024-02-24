import entity.Channel;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import services.ChannelService;

import javax.persistence.EntityManager;


public class SatelliteApplication
{
    private static final Logger LOGGER = LogManager.getLogger(SatelliteApplication.class);
    public static void main(String[] args)
    {
        LOGGER.info("Application started success!!!!");

        Channel c1 = new Channel();
        c1.setName("Sun tv");
        c1.setLanguage("Telugu");
        c1.setCost(45.67);
        ChannelService cs1 = new ChannelService();
        cs1.saveChannel(c1);

        System.out.println(cs1.getAllChannels());
//
//        Channel c2 = new Channel();
//        c2.setName("AAJ TAK");
//        c2.setLanguage("HINDI");
//        c2.setCost(25.33);
//        cs1.saveChannel(c2);

        SpringApplication.run(SatelliteApplication.class, args);
    }
}
