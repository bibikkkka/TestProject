package com.bibikkkka.testproject.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;
    private int age;
    private int weight;


    public User(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}
