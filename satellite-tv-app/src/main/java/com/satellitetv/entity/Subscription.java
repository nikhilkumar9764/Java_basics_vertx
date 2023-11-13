package com.satellitetv.entity;

import com.satellitetv.enums.Plan;
import javax.persistence.*;

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
