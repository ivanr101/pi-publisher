package org.secomm.pipublisher.webhook;

import lombok.Data;

import java.util.List;

@Data
public class Embed {

    private String title;

    private String type;

    private String description;

    private String url;

    private String timestamp;

    private int color;

    private Footer footer;

    private Image image;

    private Thumbnail thumbnail;

    private Video video;

    private Provider provider;

    private Author author;

    private List<Field> fields;
}
