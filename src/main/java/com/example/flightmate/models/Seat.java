package com.example.flightmate.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;
    @Column(nullable = false)
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SeatClass seatClass;
    @Column(nullable = false)
    private Boolean isAvailable;

    public Seat() {
    }

    public Seat(Flight flight, String seatNumber, SeatClass seatClass, Boolean isAvailable) {
        this.flight = flight;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.isAvailable = isAvailable;
    }

    public Long getId() {
        return id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", flight=" + flight +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatClass=" + seatClass +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
