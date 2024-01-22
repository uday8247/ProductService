package com.shopping.products.inheritencedemo.singleclass;

import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue(value = "2")
public class Instructor {
    private String favStudent;
}
