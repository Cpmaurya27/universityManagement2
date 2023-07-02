package com.example.universityManagment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int eventId;

    @NotEmpty
    @Size(min = 1, max = 75)
    private String eventName;

    @NotEmpty
    @Size(min = 1, max = 75)
    private String locationOfEvent;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private LocalDate date;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="HH:mm:ss")
    private String startTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="HH:mm:ss")
    private String endTime;

}
