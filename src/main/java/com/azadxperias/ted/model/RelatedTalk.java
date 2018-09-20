package com.azadxperias.ted.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelatedTalk {
    private long id;
    private String hero;
    private String speaker;
    private String title;
    private long duration;
    private String slug;
    private long viewedCount;

    @Override
    public String toString() {
        return "RelatedTalk{" +
                "id=" + id +
                ", hero='" + hero + '\'' +
                ", speaker='" + speaker + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", slug='" + slug + '\'' +
                ", viewedCount=" + viewedCount +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public long getViewedCount() {
        return viewedCount;
    }
    @JsonProperty("viewed_count")
    public void setViewedCount(long viewedCount) {
        this.viewedCount = viewedCount;
    }
}
