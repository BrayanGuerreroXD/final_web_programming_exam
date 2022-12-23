package com.example.demo.entities;

import javax.persistence.*;

import lombok.Data;

import java.sql.Date;

@Entity
@Data
@Table(name = "bill")
public class Bill {
    @Id
    @SequenceGenerator(name="bill_id_seq", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bill_id_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name = "date_bill")
    private Date dateBill;

    @Column(name = "value")
    private int value;

    @Column(name = "type")
    private int type;

    @Column(name = "observation")
    private String observation;
}
