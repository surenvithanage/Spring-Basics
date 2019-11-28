package com.aop.model;

import org.hibernate.boot.model.naming.Identifier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Project aop
 * User : suren_v
 * Date : 11/28/2019
 * Time : 9:26 AM
 */
@Entity
public class Aop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;

    public Aop() {
    }

    public Aop(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
