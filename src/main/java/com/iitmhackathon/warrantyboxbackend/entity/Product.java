package com.iitmhackathon.warrantyboxbackend.entity;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Product {
    private String brand;
    private String model;
    private String invoiceNo;
    private LocalDate warranty;
    private String seller;
    private String status;
}
