package com.example.Epicode.Entities;

import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Getter
@Setter
@ToString
@Entity
@DiscriminatorValue("bibita")
public class Bibite extends MenuItem {

    public Bibite() {
    }

    public Bibite( String name, int prezzo, int calories, Menù menu) {
        super( name, prezzo, calories, menu);
    }
}
