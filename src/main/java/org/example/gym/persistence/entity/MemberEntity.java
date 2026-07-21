package org.example.gym.persistence.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "members")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MeasurementEntity> measurements;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public List<MeasurementEntity> getMeasurements() { return measurements; }
    public void setMeasurements(List<MeasurementEntity> measurements) { this.measurements = measurements; }
}