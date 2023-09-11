package de.ait.tracker.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity///что у нас будет таблица
public class Event {

    @Id//primary key ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//будет генерироваться базой данных
    private Long id;
    private String title;
    private String description;
    private Integer maxParticipantsCount;

    private String feedbackFromAdmin;
}
