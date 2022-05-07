package com.iitmhackathon.warrantyboxbackend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Brand {
    @Id
    private String name;
    private String logo;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<SerialNoIdentifier> serialno;
    @ElementCollection
    private List<String> location;
    private Float rating;
}
