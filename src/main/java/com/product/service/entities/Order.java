package com.product.service.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    public static final long serializable = 1L;

    //attributes == columns
    @Id //PK (Primary Key) definition
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment in database
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    //attribute type enums
    //private OrderStatus orderStatus

    //association orders.* <--> client.1
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    //Constructors
    public Order(){}

    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }


    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }


    //hashCode and equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
