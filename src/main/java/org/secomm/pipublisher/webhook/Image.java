package org.secomm.pipublisher.webhook;

import lombok.Data;

@Data
public class Image {

    private String url;

    private String proxy_url;

    private int height;

    private int width;
}
