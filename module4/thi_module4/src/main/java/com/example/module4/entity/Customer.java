package com.codegym.case_study.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Validator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Customer")
public class Customer  {

    @Id
    @NotBlank(message = "Không thể để trống thông tin, vui lòng nhập đê")
    @Pattern(regexp = "(^KH-\\d{4}$)", message = "Ghi đúng định dạng mã khách hàng KH-XXXX (X là số từ 0-9)")
    private String customerId;

    @ManyToOne()
    @JoinColumn(name = "typeCustomer_id",referencedColumnName = "typeCustomerId")
    @JsonManagedReference
    private CustomerType customerType;

    @NotBlank(message = "Không thể để trống thông tin, vui lòng nhập đê")
    private String customerName;

    @NotBlank(message = "Không thể để trống thông tin, vui lòng nhập đê")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "customer_birthday", length = 50)
    private String customerBirthday;

    private String gender;

    @NotBlank(message = "Không thể để trống thông tin, vui lòng nhập đê")
    @Pattern(regexp = "(^\\d{9}$)", message = "Ghi đúng định dạng số chứng minh thư" +
            " XXXXXXXXX hoặc XXXXXXXXXXXX (X là số 0-9)")
    private String idCard;

    @NotBlank(message = "Không thể để trống thông tin, vui lòng nhập đê")
    @Pattern(regexp = "^(090|091|(84)+90|(84)+91)\\d{7}$", message = "Ghi đúng định dạng số điện thoại đúng định dạng" +
            " 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String phoneNumber;

    @NotBlank(message = "Không thể để trống thông tin, vui lòng nhập đê")
    @Email(message = " Vui lòng nhập đúng định dạng email")
    private String email;

    @NotBlank(message = "Không thể để trống thông tin, vui lòng nhập đê")
    private String address;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
