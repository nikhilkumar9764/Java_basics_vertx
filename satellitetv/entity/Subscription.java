package satellitetv.entity;

import satellitetv.enums.Plan;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Subscription
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subscriptionName;

    @ManyToOne
    private Package defaultpackage;

    @OneToMany
    private List<Channel> listofChannels;

    private Plan plan;
    private int subscPeriod;
}
