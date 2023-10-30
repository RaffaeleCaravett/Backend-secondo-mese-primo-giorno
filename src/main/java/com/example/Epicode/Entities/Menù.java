package com.example.Epicode.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Menù {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany(mappedBy = "menu")
    @OrderBy("id ASC")
    private List<MenuItem> pizze;
    @OneToMany(mappedBy = "menu")
    @OrderBy("id ASC")
    private List<MenuItem> bibite;
    @OneToMany(mappedBy = "menu")
    @OrderBy("id ASC")
    private List<MenuItem> toppings;

}
