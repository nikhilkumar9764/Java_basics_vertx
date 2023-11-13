package com.satellitetv.entity;


import javax.persistence.*;

import java.util.List;

@Entity
public class Package
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "package")
    private List<Channel> channels;

}
