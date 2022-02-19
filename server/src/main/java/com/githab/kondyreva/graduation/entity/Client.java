package com.githab.kondyreva.graduation.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "first_name", nullable = false)
    private String firstName;
    @Column (name = "second_name", nullable = false)
    private String secondName;
    @Column (name = "last_name" )
    private String lastName;

    @OneToMany(mappedBy = "client")
    private Set<Card> card;
}
