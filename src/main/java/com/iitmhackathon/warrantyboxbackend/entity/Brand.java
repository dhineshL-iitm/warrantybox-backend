package com.iitmhackathon.warrantyboxbackend.entity;

import lombok.Data;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Brand {
    @Id
    private String name;
    private String logo;
    @ElementCollection
    private List<String> serialno;
    @ElementCollection
    private List<String> location;
    private Float rating;
}
