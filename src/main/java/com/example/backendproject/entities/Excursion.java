package com.example.backendproject.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "excursions")
public class Excursion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name =  "excursion_id")
    private Long id;

    @Column(name ="excursion_title")
    private String excursion_title;

    @Column(name = "excursion_price")
    private BigDecimal excursion_price;

    @Column(name = "image_url")
    private String image_URL;

    @Column(name = "create_date")
    private Date create_date;

    @Column(name = "last_update")
    private Date last_update;

    @ManyToOne
    @JoinColumn(name = "vacation_id")
    private Vacation vacation;

    @ManyToMany(mappedBy = "excursions")
    private Set<CartItem> cartItems = new HashSet<>();

}