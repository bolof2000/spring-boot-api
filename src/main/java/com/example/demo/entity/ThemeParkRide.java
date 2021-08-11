package com.example.demo.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class ThemeParkRide {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;
    private int thrillFactor;
    private int vomitFactor;


    public ThemeParkRide(String name,String description,int thrillFactor,int vomitFactor){
        this.name = name;
        this.description= description;
        this.thrillFactor = thrillFactor;
        this.vomitFactor = vomitFactor;
    }
}
