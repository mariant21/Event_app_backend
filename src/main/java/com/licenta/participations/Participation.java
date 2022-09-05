package com.licenta.participations;

import com.licenta.auth.models.User;
import com.licenta.eventfields.EventFields;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "participations")
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    EventFields event;

    public Participation(User user, EventFields event) {
        this.user = user;
        this.event = event;
    }

    public Participation() {
    }

    public Participation(Long id, User user, EventFields event) {
        this.id = id;
        this.user = user;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EventFields getEvent() {
        return event;
    }

    public void setEvent(EventFields event) {
        this.event = event;
    }
}
