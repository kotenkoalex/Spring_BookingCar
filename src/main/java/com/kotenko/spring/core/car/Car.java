package com.kotenko.spring.core.car;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Engine engine;
    private Brand brand;
}
