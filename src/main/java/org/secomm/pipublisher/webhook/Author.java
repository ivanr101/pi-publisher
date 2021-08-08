package org.secomm.pipublisher.webhook;

import lombok.Data;
import lombok.NonNull;

@Data
public class Author {

    @NonNull
    private String name;

    private String url;

    private String icon_url;

    private String proxy_icon_url;
}
