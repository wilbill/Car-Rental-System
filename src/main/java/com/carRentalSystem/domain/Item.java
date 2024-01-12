package com.carRentalSystem.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne //by default uses a join table, so im trying to force it use a join column...but manytomany shd be join table
    @JoinColumn( name= "car_Column")
    private Car car;
    private LocalDate checkOutDate;
    private LocalDate checkinDate;
    @Embedded
    private AuditData auditData = new AuditData();
    @ManyToOne
    @JoinColumn(name="Item_Booking")
    private Booking booking;
    public Item(){
    }

    public Item(Car car, LocalDate checkOutDate, LocalDate checkinDate, AuditData auditData, Booking booking) {
        this.car = car;
        this.checkOutDate = checkOutDate;
        this.checkinDate = checkinDate;
        this.auditData = auditData;
        this.booking = booking;
    }
}
