package com.food.OnlineFoodOrdering.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.Data;
@Embeddable
@Data
public class ContactInformation {
    private String email;
    private String mobile;
    private String twitter;
    private String instagram;

}
