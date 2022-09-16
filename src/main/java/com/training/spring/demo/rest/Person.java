package com.training.spring.demo.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name="personel")
public class Person {
    @Id
    @GeneratedValue
    private Long personId;
    @NotNull(message = "Name null olamaz")
    @NotEmpty
    @Size(min = 2,max = 15)
    @Column(name="desc")
    private String name;
    @NotEmpty
    @Size(min = 3,max = 20)
    private String surname;
    @NotNull
    @Min(100)
    @Max(300)
    @Positive
    private Integer height;
    @NotNull
    @Min(10)
    @Max(300)
    @Positive
    private Integer weight;

    // @Transient
    @OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Phone> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
