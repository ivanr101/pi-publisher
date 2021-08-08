package org.secomm.pipublisher.webhook;

import lombok.Data;

import java.util.List;

@Data
public class WebhookContent {

    protected String content;

    private String username;

    private String avatar_url;

    private boolean tts;

    private String file;

    private List<Embed> embeds;

    private String json_payload;

    private AllowedMention allowed_mentions;

    private List<MessageComponent> message_components;
}
