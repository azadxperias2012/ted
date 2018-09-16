package com.azadxperias.ted.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class TedEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ted_event_id")
    private Integer id;
    @Lob
    private String description;
    private String event;
    private String mainSpeaker;
    private String name;
    private String publishedDate;
    private String speakerOccupation;
    private String title;
    private String url;
    private String views;
    @Transient
    private String ratings;
    @Transient
    private String relatedTalks;
    @Transient
    private String tags;

    @Transient
    private List<Rating> tedEventRatings;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getMainSpeaker() {
        return mainSpeaker;
    }

    public void setMainSpeaker(String mainSpeaker) {
        this.mainSpeaker = mainSpeaker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSpeakerOccupation() {
        return speakerOccupation;
    }

    public void setSpeakerOccupation(String speakerOccupation) {
        this.speakerOccupation = speakerOccupation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "TedEvent{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", event='" + event + '\'' +
                ", mainSpeaker='" + mainSpeaker + '\'' +
                ", name='" + name + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", speakerOccupation='" + speakerOccupation + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", views='" + views + '\'' +
                ", ratings='" + getTedEventRatings() + '\'' +
                '}';
    }

    public List<Rating> getTedEventRatings() {
        return tedEventRatings;
    }

    public void setTedEventRatings(List<Rating> tedEventRatings) {
        this.tedEventRatings = tedEventRatings;
    }

    public String getRelatedTalks() {
        return relatedTalks;
    }

    public void setRelatedTalks(String relatedTalks) {
        this.relatedTalks = relatedTalks;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
