package com.vergilon.friend_service.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "hobbies")
public class Hobby {

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
    @ManyToMany(mappedBy = "hobbies", targetEntity = User.class)
    @JsonIgnore
    List<User> users;
}
