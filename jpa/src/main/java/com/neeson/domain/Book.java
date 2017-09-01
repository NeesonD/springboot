package com.neeson.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by daile on 2017/9/1.
 */
@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String isbn;

    private Date publishDate;

    @ManyToMany(mappedBy = "books")
    private Collection<Customer> customers;


}
