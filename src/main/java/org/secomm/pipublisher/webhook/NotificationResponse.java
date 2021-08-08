package org.secomm.pipublisher.webhook;

import lombok.Data;

@Data
public class NotificationResponse {

    private String message;

    private float retry_after;

    private boolean global;
}
