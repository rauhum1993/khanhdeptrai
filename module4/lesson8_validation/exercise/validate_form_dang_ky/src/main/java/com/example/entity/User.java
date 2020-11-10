package com.example.entity;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity(name = "User")
public class User implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Không được để trống ")
    @Size(min = 5, max = 45, message = "Số ký tự tối thiểu là 5 và tối đa là 45")
    private String firstName;

    @NotBlank(message = "Không được để trống ")
    @Size(min = 5, max = 45, message = "Số ký tự tối thiểu là 5 và tối đa là 45")
    private String lastName;
    @Pattern(regexp = "(^0\\d{9}$)", message = "Ghi đúng định dạng số điện thoại")
    private String phoneNumber;

    @Min(value = 18, message = "Tối thiếu 18 tuổi")
    private int age;

    @Email(message = "Ghi đúng định dạng email codegym@gmail.com")
    private String email;

    public Integer getId() {
        return id;
    }

    public User() {
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (("").equals(user.firstName)) {
            errors.rejectValue("firstName", "name.empty");
        }

    }
}
