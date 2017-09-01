package com.neeson.domain;

import com.neeson.domain.listener.CustomerListener;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by daile on 2017/9/1.
 */
@Entity
@Access(value = AccessType.FIELD)
@Table(name = "customers")
@EntityListeners(value = {CustomerListener.class})
@Data
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 64)
    private String name;

    @OneToOne
    private CreditCard creditCard;

    @ManyToOne
    private Store store;

    @OneToMany
    private Collection<Book> books;

}
