package com.codeDuo.myTime.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class HabitHasMyDate {

    @EmbeddedId
    private HabitHasMyDateId habitHAsMyDateId;

    @ManyToOne
    @JoinColumn(name = "habitId")
    @MapsId("habitId")
    private Habit habit;

    @ManyToOne
    @JoinColumn(name = "myDateId")
    @MapsId("myDateId")
    private MyDate myDate;

    @Builder.Default
    @ColumnDefault("false")
    private Boolean isDone = false;
}
