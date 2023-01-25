package com.example.inventoryservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sku_code")
    private String skuCode;

    private Integer quantity;



}
