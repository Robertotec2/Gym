package org.example.gym.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "trainers")
public class TrainerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "specialty")
    private String specialty;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<MemberEntity> members;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public List<MemberEntity> getMembers() { return members; }
    public void setMembers(List<MemberEntity> members) { this.members = members; }
}