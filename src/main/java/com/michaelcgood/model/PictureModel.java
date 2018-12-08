package com.michaelcgood.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "picture_model_1")
public class PictureModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "picture_id")
    private long pictureId;

    @Lob
    @Column(name = "picture")
    private String picture;

    public void setPictuteId(long pictuteId) {
        this.pictureId = pictuteId;
    }

    public long getPictuteId() {
        return pictureId;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture() {
        return picture;
    }
}
