package com.example.backendproject.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "divisions")
public class Division {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    @Column(name = "division_id")
    private Long id;

    @JsonProperty("division_name")
    @Column(name = "division")
    private String division_name;

    @CreationTimestamp
    @Column(name = "create_date")
    private Date create_date;

    @UpdateTimestamp
    @Column(name = "last_update")
    private Date last_update;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers = new HashSet<>();

    @JsonProperty("country_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false, insertable = false, updatable = false)
    private Country country;

    @JsonProperty("country_id")
    @Column(name = "country_id")
    private Long country_id;
    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }
}
