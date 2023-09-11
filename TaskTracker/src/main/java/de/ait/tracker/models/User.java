package de.ait.tracker.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 8/1/2023
 * TaskTracker
 *
 * @author Marsel Sidikov (AIT TR)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="account")
public class User {

    @Id//primary key ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//сгенерировал
    private Long id;

    private String firstName;

    private String lastName;
}
