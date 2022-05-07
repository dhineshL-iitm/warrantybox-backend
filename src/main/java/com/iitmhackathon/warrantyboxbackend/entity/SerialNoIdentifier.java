package com.iitmhackathon.warrantyboxbackend.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class SerialNoIdentifier {

    @Id
    private String serialNo;
    private String model;
    private String localDate;
    private String warranty;
    private String brandName;
}
