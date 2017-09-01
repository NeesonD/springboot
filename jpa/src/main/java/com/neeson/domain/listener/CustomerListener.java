package com.neeson.domain.listener;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

/**
 * 持久化监听器
 * Created by daile on 2017/9/1.
 */
public class CustomerListener {

    @PrePersist
    public void prePersist(Object source) {
        System.out.println("@PrePersist:" + source);
    }

    @PostPersist
    public void postPersist(Object source) {
        System.out.println("@PostPersist:" + source);
    }

}
