package com.akhtaraf.assignment2.data.jpa.entity;

import com.akhtaraf.assignment2.model.PetGender;
import com.akhtaraf.assignment2.model.PetType;
import jakarta.persistence.*;

@Entity
@Table(name = "pet")
public class PetEntity {

    // Column id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id = null;

    // Column name
    private String name = "";

    //Column pet_gender
    @Column(name = "pet_gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private PetGender petGender = PetGender.FEMALE;

    //Column pet_type
    @Column(name = "pet_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PetType petType = PetType.DOG;

    // Column vaccinated
    @Column(name = "vaccinated", nullable = false)
    private  Boolean vaccinated = false;

    // Entity Constructor
    public PetEntity(String name, PetGender petGender, PetType petType, Boolean vaccinated) {
        this.name = name;
        this.petGender = petGender;
        this.petType = petType;
        this.vaccinated = vaccinated;
    }

    // Entity Default Constructor
    public PetEntity() {

    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetGender getPetGender() {
        return petGender;
    }

    public void setPetGender(PetGender petGender) {
        this.petGender = petGender;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }


}
