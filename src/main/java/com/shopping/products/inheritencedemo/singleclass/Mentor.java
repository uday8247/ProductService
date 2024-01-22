package com.shopping.products.inheritencedemo.singleclass;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value = "1")
public class Mentor extends User {
    private double avg_rating;
}
