package org.secomm.pipublisher.webhook;

import lombok.Data;

@Data
public class Field {

    private String name;

    private String value;

    private boolean inline;
}
