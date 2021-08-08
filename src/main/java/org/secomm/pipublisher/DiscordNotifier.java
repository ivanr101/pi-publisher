package org.secomm.pipublisher;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.secomm.pipublisher.webhook.Embed;
import org.secomm.pipublisher.webhook.WebhookContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Component
public class DiscordNotifier {

    private static final Logger log = LoggerFactory.getLogger(DiscordNotifier.class);

    private final Gson gson;

    public DiscordNotifier() {

        gson = new GsonBuilder().create();
    }

    public void sendWebhook(WebhookContent webhookContent, String webhook) {

        try {
            String json = gson.toJson(webhookContent);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(webhook))
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .header("Content-Type", "application/json")
                    .build();

            HttpClient client = HttpClient.newBuilder().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info("Discord webhook notification response: {}", response.body());
        } catch (Exception e) {
            log.error("Exception in discord webhook notifier: {}", e.getLocalizedMessage());
        }

    }
}
