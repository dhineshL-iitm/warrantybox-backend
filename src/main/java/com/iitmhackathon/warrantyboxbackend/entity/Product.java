package com.iitmhackathon.warrantyboxbackend.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class Product {
    @Id
    private String invoiceNo;
    private String brand;
    private String model;
    private String warranty;
    private String seller;
    private String status;
    private String username;
}
