package entity;

import enums.Plan;
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
    private List<Package> listofPackages;


    private Plan plan;
    private int subscPeriod;
}
