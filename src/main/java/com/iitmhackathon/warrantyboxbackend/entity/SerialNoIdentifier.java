package com.iitmhackathon.warrantyboxbackend.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class SerialNoIdentifier {

    @Id
    private String serialNo;
    private String model;
    private LocalDate localDate;
    private LocalDate warrantyTime;

}
