package com.vergilon.friend_service.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pg-uuid")
    @GenericGenerator(
            name = "pg-uuid",
            strategy = "uuid2",
            parameters = @Parameter(
                    name = "uuid_gen_strategy_class",
                    value = "com.vergilon.friend_service.util.PostgreSQLUUIDGenerationStrategy"
            )
    )
    private UUID id;
    @Column
    private String name;

}
