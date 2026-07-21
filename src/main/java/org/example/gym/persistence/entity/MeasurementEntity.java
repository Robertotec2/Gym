package org.example.gym.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "measurements")
public class MeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "weight_kg")
    private Double weight;

    @Column(name = "measurement_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public MemberEntity getMember() { return member; }
    public void setMember(MemberEntity member) { this.member = member; }
}