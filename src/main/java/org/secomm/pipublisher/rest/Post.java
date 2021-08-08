package org.secomm.pipublisher.rest;

import lombok.Data;
import lombok.NonNull;
import org.secomm.pipublisher.webhook.WebhookContent;

@Data
public class Post {

    @NonNull
    private WebhookContent webhookContent;

    @NonNull
    private String webhook;
}
