package com.neeson.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by daile on 2017/9/1.
 */
@Entity
@Table(name = "stores")
@Data
public class Store {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "store")
    private Collection<Customer> customers;

}
