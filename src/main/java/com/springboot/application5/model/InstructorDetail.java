package com.springboot.application5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="instructor_detail")
@Getter
@Setter
@NoArgsConstructor
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //kimlik
    @Column(name="id")
    private int id;

    @Column(name="adress")
    private String adress;

    @Column(name="hobby")
    private String hobby;

    @JsonIgnore
    @OneToOne(mappedBy = "instructorDetail")  //instructor sınıfındaki instructorDetail i ifade ediyor.
    //@PrimaryKeyJoinColumn
    private Instructor instructor;

    public InstructorDetail(String adress, String hobby) {
        this.adress = adress;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                ", hobby='" + hobby + '\'' +
                ", instructor=" + instructor +
                '}';
    }
}
