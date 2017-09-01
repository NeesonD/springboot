package com.neeson.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

/**
 * Created by daile on 2017/9/1.
 */
@Inheritance
@Entity
public class VipCustomer extends Customer{

   private Double discount;

    public VipCustomer(Double discount) {
        this.discount = discount;
    }
}
