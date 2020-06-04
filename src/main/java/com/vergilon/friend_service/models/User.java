package com.vergilon.friend_service.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pg-uuid")
    @GenericGenerator(
            name = "pg-uuid",
            strategy = "uuid2",
            parameters = @org.hibernate.annotations.Parameter(
                    name = "uuid_gen_strategy_class",
                    value = "com.vergilon.friend_service.util.PostgreSQLUUIDGenerationStrategy"
            )
    )
    private UUID id;
    @Column
    private String name;
    @Column
    private int age;
    @ManyToOne
    @JoinColumn(name="city_id", nullable=false)
    private City city;
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Hobby.class)
    @JoinTable(
            name = "users_hobbies",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "hobby_id"))
    private List<Hobby> hobbies;

    public void addHobby(Hobby hobby) {
        hobbies.add(hobby);
    }

    public void addHobbies(List<Hobby> hobbies) {
        this.hobbies.addAll(hobbies);
    }

}
