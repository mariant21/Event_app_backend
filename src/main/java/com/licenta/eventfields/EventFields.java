package com.licenta.eventfields;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name= "event_fields")
public class EventFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Date beginDate;
    private Date endDate;
    private Long price;
    private String picture;


    public EventFields() {
    }

    public EventFields(String title, String description, Date beginDate, Date endDate, Long price, String picture) {
        this.title = title;
        this.description = description;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.price = price;
        this.picture = picture;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Date getBeginDate() { return beginDate; }

    public void setBeginDate(Date beginDate) { this.beginDate = beginDate; }

    public Date getEndDate() { return endDate; }

    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Long getPrice() { return price; }

    public void setPrice(Long price) { this.price = price; }

    public String  getPicture() { return picture; }

    public void setPicture(String picture) { this.picture = picture; }


}
