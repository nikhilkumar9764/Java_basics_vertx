package satellitetv;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import satellitetv.entity.Channel;
import satellitetv.services.ChannelService;

import java.util.List;

@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan({"repositories", "entity"})
@EnableJpaRepositories("repositories")
@SpringBootApplication
public class SatelliteApplication
{
    private static final Logger LOGGER = LogManager.getLogger(SatelliteApplication.class);
    public static void main(String[] args) {
        LOGGER.info("Application started success!!!!");

        Channel c1 = new Channel();
        c1.setName("Sun tv");
        c1.setLanguage("Telugu");
        c1.setCost(45.67);
        ChannelService cs1 = new ChannelService();
        cs1.saveChannel(c1);

        Channel c2 = new Channel();
        c1.setName("AAJ TAK");
        c1.setLanguage("HINDI");
        c1.setCost(25.33);
        cs1.saveChannel(c2);

        List<Channel> r1 = cs1.get();
        System.out.println(r1);
        SpringApplication.run(SatelliteApplication.class, args);
    }
}
