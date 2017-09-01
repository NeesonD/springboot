package com.neeson.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by daile on 2017/9/1.
 */
@Entity
@Table(name = "credit_cards")
@Data
public class CreditCard {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 128)
    private String number;

    @Column(name = "reg_date")
    private Date registeredDate;

    @OneToOne(mappedBy = "creditCard")
    private Customer customer;

}
