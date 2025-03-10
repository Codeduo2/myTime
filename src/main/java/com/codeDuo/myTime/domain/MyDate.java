package com.codeDuo.myTime.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class MyDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder.Default
    @OneToMany(mappedBy = "myDate", cascade = {CascadeType.REMOVE}, orphanRemoval = true)
    private List<ToDo> toDos = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "myDate", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<HabitHasMyDate> habitHasMyDates = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "myDate", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<ScheduleHasMyDate> scheduleHasMyDates = new ArrayList<>();
}
