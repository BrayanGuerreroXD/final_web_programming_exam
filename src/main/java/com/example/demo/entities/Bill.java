package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

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

    private Date dateBill;

    private int value;

    private int type;

    private String observation;
}
