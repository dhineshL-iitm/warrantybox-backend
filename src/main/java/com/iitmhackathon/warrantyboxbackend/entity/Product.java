package com.iitmhackathon.warrantyboxbackend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


@Data
@Entity
public class Product {
    @Id
    private String invoiceNo;
    private String brand;
    private String model;
    private LocalDate warranty;
    private String seller;
    private String status;
    private String username;
}
