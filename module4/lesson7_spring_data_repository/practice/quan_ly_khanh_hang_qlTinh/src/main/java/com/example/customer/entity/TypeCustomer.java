package com.example.customer.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "type_customer")
public class TypeCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer type_id;
    private String type_name;

    @OneToMany(mappedBy = "typeCustomer", cascade = CascadeType.ALL)
    private List<Customer> customerList;

    public TypeCustomer() {
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
