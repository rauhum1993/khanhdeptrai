package com.codegym.case_study.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typeCustomer")
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer typeCustomerId;


    private String typeCustomerName;

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    @OneToMany(mappedBy = "customerType")
    @JsonBackReference
    private List<Customer> customer;

    public Integer getTypeCustomerId() {
        return typeCustomerId;
    }

    public void setTypeCustomerId(Integer typeCustomerId) {
        this.typeCustomerId = typeCustomerId;
    }

    public String getTypeCustomerName() {
        return typeCustomerName;
    }

    public void setTypeCustomerName(String typeCustomerName) {
        this.typeCustomerName = typeCustomerName;
    }


}
